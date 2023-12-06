<script>

import ModeInformation from "@/components/ModeInformation.vue";
import router from "@/router";
import store from "@/store";
export default {
  name: "SelfInformation_mila",
  props:['drawer'],
  components: {
    Mode: ModeInformation
  },
  data() {
    return {
      flag: false,
      user: {},
      authorityFlag: true
    }
  },
  methods: {
    logOut() {
      sessionStorage.removeItem("user")
      this.flag=true
      router.push("/login")
    }
  },
  mounted() {
    this.user = JSON.parse(sessionStorage.getItem("user"))
    if(store.state.authority === "Customer") this.authorityFlag = true
    else if(store.state.authority === "Admin") this.authorityFlag = false
  },
  watch:{
    drawer(oldValue , newValue) {
      this.flag =  true   // 触发器触发之后改变值为true
      console.log(newValue)
      console.log(this.flag)
    }
  }

}
</script>

<template>
  <el-drawer v-model="flag" title="个人主页" :with-header="false" :direction="'ltr'">
    <el-avatar size="large"
        src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
    />
    <el-descriptions
        title="用户信息"
        direction="vertical"
        :column="4"
        :size="'medium'"
    >
      <el-descriptions-item label="用户名">{{user.username}}</el-descriptions-item>
      <el-descriptions-item label="电话">{{user.phone}}</el-descriptions-item>
      <el-descriptions-item label="邮箱" :span="2">{{ user.mail }}</el-descriptions-item>
      <el-descriptions-item label="可借书数量" v-if="authorityFlag">{{user.lendBookNum}}</el-descriptions-item>
      <el-descriptions-item label="未还书数量" v-if="authorityFlag">{{user.unReturnedNum}}</el-descriptions-item>
    </el-descriptions>
    <Mode></Mode>
    <el-button type="danger" style="margin-left: 30px" @click="logOut">登出</el-button>
  </el-drawer>
</template>

<style scoped>

</style>