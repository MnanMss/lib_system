<script>

import request from "@/until/request";
import router from "@/router"

export default {
  name: "ManagementBook_mila",
  data() {
    return {
      books: []
    }
  },
  mounted() {
    request.post("/api/book/findALl").then(res => {
      if(res.data.code === "-1") {
        this.$message({
          message: res.data.msg,
          type: "error"
        })
      }
      else {
        this.books = res.data.data
      }
    })
  },
  methods: {
    goToModify(book) {
      sessionStorage.setItem("modifyBook" , JSON.stringify(book))
      router.push("/addBook")
    },
    deleteBook(index ,book) {
      this.books.splice(index , 1)
      request.delete("api/book/deleteBook/" + book.id)
    }
  }
}
</script>

<template>
  <el-table
      :data="books"
      style="width: 100%"
      :table-layout="'fixed'"
      border>
    <el-table-column label="书名" prop="bookName"/>
    <el-table-column label="作者" prop="author"/>
    <el-table-column label="价格" sortable prop="price"/>
    <el-table-column label="出版商" prop="bookCompany"/>
    <el-table-column label="出版日期" prop="publishDate"/>
    <el-table-column label="藏馆总数" prop="totalNumber" sortable/>
    <el-table-column label="剩余数量" prop="freeNumber" sortable/>
    <el-table-column fixed="right" label="操作" width="120">
      <template #default="scope">
        <el-button link type="primary" size="small" @click="goToModify(scope.row)"
        >修改</el-button
        >
        <el-popconfirm title="确认删除" @confirm="deleteBook(scope.$index ,scope.row)">
          <template #reference><el-button link type="danger" size="small">删除</el-button></template>
        </el-popconfirm>
      </template>
    </el-table-column>
  </el-table>
</template>

<style scoped>

</style>