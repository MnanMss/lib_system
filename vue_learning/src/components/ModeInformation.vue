<script>
import request from "@/until/request"
import router from "@/router";

export default {
  name: "ModeInformation_mila",
  data() {
    return {
      dialogFormVisible: false,
      form: {
        username: 'mila',
        password: '',
        confirmPassword: ''
      },
      user:{}
    }
  },
  mounted() {
    this.user = JSON.parse(sessionStorage.getItem("user"))
  },
  methods: {
    submit(){
      this.dialogFormVisible=false
      this.user.password = this.form.password
      request.put("api/Customer/modify" , this.user)
      sessionStorage.removeItem("user")
      router.push("/login")
    }
  }
}
</script>

<template>
  <el-button type="info" @click="dialogFormVisible = true">修改个人信息</el-button>

  <el-dialog v-model="dialogFormVisible" title="提交修改">
    <el-form :model="form">
      <el-form-item label="用户名"><el-text type="primary"></el-text>{{form.username}}</el-form-item>
      <el-form-item lable="密码">
        <el-input v-model="form.password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="form.confirmPassword" placeholder="请重写输入密码"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="dialogFormVisible=false">取消</el-button>
      <el-button type="primary" @click="submit">提交</el-button>
    </template>
  </el-dialog>

</template>

<style scoped>

</style>