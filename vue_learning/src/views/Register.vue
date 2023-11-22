<script>
import router from "@/router";

export default {
  name: "Register_mila",
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
      }
    }
  },
  methods: {
    handle() {
      console.log('注册信息：', this.loginForm.value);

      router.push('/search')
      this.$message({
        message: "注册成功",
        type: "success"
      })
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
              prefix-icon="el-icon-user"
              autocomplete="off">
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-input
              type="password"
              v-model="loginForm.password"
              placeholder="密码"
              prefix-icon="el-icon-lock"
              autocomplete="off"
              show-password>
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