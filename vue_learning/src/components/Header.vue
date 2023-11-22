<script setup>
import { ref } from 'vue'
import {defineComponent} from "vue";
import router from "@/router";

const activeIndex = ref('1')
const handleSelect = (key) => {
  console.log(key)
  router.push(key)
}
defineComponent({
  name: 'Header_mila'
})

</script>

<template>
  <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      :ellipsis="false"
      @select="handleSelect"
  >
    <el-menu-item index="/search">
      <img
          style="width: 100px"
          src="http://element-plus.org/images/element-plus-logo.svg"
          alt="Element logo"
      />
    </el-menu-item>
    <div class="flex-grow" />
    <el-menu-item index="/search" >主页</el-menu-item>
    <el-sub-menu index="2">
      <template #title>功能</template>
      <el-menu-item index="/bookList">图书主页</el-menu-item>
      <el-menu-item index="/rend">借阅服务</el-menu-item>
      <el-menu-item index="2-3">还书服务</el-menu-item>
      <el-sub-menu index="2-4">
        <template #title>个人信息</template>
        <el-menu-item index="2-4-1">个人主页</el-menu-item>
        <el-menu-item index="2-4-2">设置</el-menu-item>
      </el-sub-menu>
    </el-sub-menu>
  </el-menu>
</template>

<style scoped>
.flex-grow {
  flex-grow: 1;
}
</style>