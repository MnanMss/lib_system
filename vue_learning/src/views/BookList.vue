<script>
import lend from '@/components/LendDetails.vue'
import request from '@/until/request'
import router from "@/router";
export default {
  name: "BookList_mila",
  components: {
    lend: lend
  },
  data() {
    return {
      books: [

      ],
      totalBooks: 10
    }
  },
  mounted() {
      request.post("api/book/findALl").then(res => {
        if(res.data.code === "-1") {
          this.$message({
            message: res.data.msg,
            type: "error"
          })
        }
        else {
          this.books = res.data.data
          console.log(res.data.data)
        }
      })
  },
  methods: {
    detail(book) {
      sessionStorage.setItem("nowBook" , JSON.stringify(book))
      router.push("/bookDetails")
    },
    lend(book) {
      sessionStorage.setItem("nowBook" , JSON.stringify(book))
    }
  }

}
</script>

<template>
<!--  <div class="search-bar">-->
<!--    <el-input placeholder="搜索图书" v-model="searchQuery" />-->
<!--  </div>-->
  <el-row :gutter="20" style="margin-left: 2%">
    <el-col :xs="12" :sm="6"  v-for="book in books" :key="book.id">
      <el-card class="book-card" style="overflow: hidden">
        <div class="image-container">
          <img :src="book.imgSrc" alt="Book Cover" style="max-width: 100%; height: 150px; object-fit: cover"/>
        </div>
        <div >
          <h3 style="height: 30px">{{ book.bookName }}</h3>
          <p style="height: 30px">{{ book.description }}</p>
          <el-button type="text" @click="detail(book)">图书详情</el-button>
          <lend @myClick="lend(book)"></lend>
        </div>
      </el-card>
    </el-col>
  </el-row>
  <el-pagination
      background
      layout="prev, pager, next"
      :total="totalBooks"
  ></el-pagination>
</template>

<style scoped>
.book-card {
  max-width: 300px;
  margin: 10px 0 10px 0;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  transition: 0.3s;
  cursor: pointer;
}

.book-card:hover {
  box-shadow: 0 4px 20px 0 rgba(0, 0, 0, 0.2);
}

.image-container img {
  width: 100%;
  height: auto;
  display: block;
}
.search-bar {
  margin-bottom: 20px; /* 为搜索栏和卡片列表之间添加一些空间 */
}
</style>