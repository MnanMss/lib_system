<script>
import router from "@/router";
import request from "@/until/request"
import {Unlock, User} from "@element-plus/icons-vue";
import store from "@/store";

export default {
  name: 'Login_mila',
  computed: {
    Unlock() {
      return Unlock
    },
    User() {
      return User
    }
  },
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
      },
      disable_flag: true
    }
  },
  methods: {
    handle() {
      if(this.loginForm.username==='' || this.loginForm.password==='') {
        this.$message({
          message:"用户名或密码错误",
          type: "warning"
        })
        return
      }

      request.post("api/Customer/login" , this.loginForm).then(res =>{
        if(res.data.code === '0'){
          this.$message({
            message:"登录成功",
            type: "success"
          })
          if(res.data.data.authority === "Admin") {
            store.commit('setAuthority' , 'Admin')
          }
          sessionStorage.setItem("user" , JSON.stringify(res.data.data)) // 缓存用户信息
          router.push('/search')
        } else {
          this.$message({
            message: res.data.msg,
            type: "error"
          })
        }
      })
    },
    register() {
      router.push('/register')
    }
  }
};
</script>

<template>
  <div class="login-wrapper">
    <el-card class="login-box">
      <div class="title">图书管理系统</div>
      <el-form ref="loginForm" :model="loginForm" label-position="top">
        <el-form-item>
          <el-input
              v-model="loginForm.username"
              placeholder="用户名"
              :prefix-icon="User"
              autocomplete="off">
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-input
              type="password"
              v-model="loginForm.password"
              placeholder="密码"
              :prefix-icon='Unlock'
              autocomplete="off"
              show-password>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" block @click="handle">登录</el-button>
          <el-button type="primary" block @click="register">注册</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<style scoped>
.login-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f2f3f5;
}

.login-box {
  width: 400px;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  background: white;
  transition: all 0.3s ease;
}

.login-box:hover {
  transform: translateY(-5px);
  box-shadow: 0 5px 20px rgba(0, 0, 0, 0.2);
}

.title {
  font-size: 24px;
  text-align: center;
  margin-bottom: 20px;
  color: #333;
}

.el-form-item {
  margin-bottom: 10px;
}

.el-button {
  height: 40px;
  line-height: 40px;
}
</style>