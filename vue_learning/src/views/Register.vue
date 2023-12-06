<script>
import router from "@/router";
import request from "@/until/request"
import {Iphone, User, Unlock , Message} from "@element-plus/icons-vue";
// import {Message} from "element-ui";


export default {
  name: "Register_mila",
  computed: {
    Iphone() {
      return Iphone
    },
    Unlock() {
      return Unlock
    },
    User() {
      return User
    },
    Message() {
      return Message
    }
  },
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
        phone: '',
        mail: ''
      },
      confirmPassword: ''
    }
  },
  methods: {
    handle() {

      if(
          this.loginForm.username === '' ||
          this.loginForm.password === '' ||
          this.loginForm.phone === '' ||
          this.loginForm.mail === ''
      ) {
        this.$message({
          message: '请填写完整信息',
          type: 'warning'
        })
        return
      }

      if(this.loginForm.password !== this.confirmPassword) {
        this.$message({
          message: '两次密码不相同',
          type: 'warning'
        })
        return
      }

      request.post("api/Customer/register" , this.loginForm).then(res=>{
        this.$message({
          message: res.data.msg,
          type: res.data.code === '0' ? 'success' : 'error'
        })
        if(res.data.code === '0') {
          sessionStorage.setItem("user" , JSON.stringify(res.data.data))
        }
      })
      router.push('/search')
    }
  }
}
</script>

<template>
  <router-view></router-view>
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
          <el-input
              type="password"
              v-model="confirmPassword"
              placeholder="确认密码"
              :prefix-icon='Unlock'
              autocomplete="off"
              show-password>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-input
              v-model="loginForm.phone"
              placeholder="电话"
              :prefix-icon="Iphone"
          >
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-input
              v-model="loginForm.mail"
              placeholder="邮箱"
              :prefix-icon="Message"
          >
          </el-input>

        </el-form-item>
        <el-form-item>
          <el-button type="primary" block @click="handle">注册</el-button>
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