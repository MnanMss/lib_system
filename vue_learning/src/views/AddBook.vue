<script >
import request from "@/until/request"
import router from "@/router";
export default {
  name: "AddBook_mila",
  data() {
    return {
      form: {
        isbn:'',
        bookName: '',
        image: null,
        description: '',
        author: '',
        bookCompany: '',
        price: '',
        publishDate: '',
        totalNumber: 0
      },
      modifyFlag: false
    }
  },
  methods: {
    handleFileChange(file) {
      this.form.image = file.raw;
    },
    submitForm() {
      const formDate = new FormData()
      for(const key in this.form) {
        if(key === 'image' && this.form.image) {
          formDate.append('image' , this.form.image)
        }else {
          formDate.append(key , this.form[key])
        }
      }
      if(this.modifyFlag) {
        request.put("api/book/ModifyBook" , formDate ,{
          headers: {
            'Content-Type': 'multipart/form-data'
          }}).then(res=>{
          if(res.data.code === '-1') {
            this.$message({
              message: res.data.msg,
              type: "error"
            })
          }else {
            this.$message({
              message: "修改成功",
              type: "success"
            })
          }
        })
      }else {
        request.post("api/book/add" , formDate ,  {
          headers: {
            'Content-Type': 'multipart/form-data'
          }}).then(res => {
          if(res.data.code === '-1') {
            this.$message({
              message: res.data.msg,
              type: "error"
            })
          }
          else {
            this.$message({
              message: res.data.msg,
              type: "success"
            })
          }
        })
      }
      router.push("/managementBook")
      window.location.reload()
    }
  },
  mounted() {
    let book = JSON.parse(sessionStorage.getItem("modifyBook"))
    if(book) {
      this.form = book;
      this.modifyFlag = true
      sessionStorage.setItem("modifyBook" , null)
    }
  }
}
</script>

<template>
  <el-form ref="form" :model="form" label-width="120px">
    <el-form-item label="ISBN">
      <el-input v-model="form.isbn"></el-input>
    </el-form-item>
    <el-form-item label="书名">
      <el-input v-model="form.bookName"></el-input>
    </el-form-item>
    <el-form-item label="描述">
      <el-input type="textarea" v-model="form.description"></el-input>
    </el-form-item>
    <el-form-item label="作者">
      <el-input v-model="form.author"></el-input>
    </el-form-item>
    <el-form-item label="出版社">
      <el-input v-model="form.bookCompany"></el-input>
    </el-form-item>
    <el-form-item label="价格">
      <el-input v-model="form.price"></el-input>
    </el-form-item>
    <el-form-item label="发布日期">
      <el-date-picker v-model="form.publishDate" type="date"  value-format="YYYY-MM-DD"></el-date-picker>
    </el-form-item>
    <el-form-item label="总数量">
      <el-input-number v-model="form.totalNumber" :min="0"></el-input-number>
    </el-form-item>
    <el-form-item label="剩余数量" v-if="modifyFlag">
      <el-input-number v-model="form.freeNumber" :min="0" :max="form.totalNumber"></el-input-number>
    </el-form-item>
    <el-form-item label="封面图片">
      <el-upload
          list-type="picture"
          :auto-upload="false"
          :on-change="handleFileChange">
        <el-button size="small" type="primary">选择图片</el-button>
      </el-upload>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm">提交</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped>

</style>