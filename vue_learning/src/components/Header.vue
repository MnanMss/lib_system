<script setup>
import { ref } from 'vue'
import {defineComponent} from "vue";
import router from "@/router";
import selfInformation from "@/components/SelfInformation.vue";

const activeIndex = ref('1')
const handleSelect = (key) => {
  console.log(key)
  router.push(key)
}

const drawer = ref(false)
defineComponent({
  name: 'Header_mila'
})

const onClick = ()=> {
  drawer.value = !drawer.value   // 触发器   每次改变触发子组件的监听方法
  console.log(drawer.value)
}

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
      <el-menu-item index="/rend">还书服务</el-menu-item>
      <el-menu-item  @click="onClick">个人信息</el-menu-item>
      <el-menu-item index="/managementBook">管理图书</el-menu-item>
    </el-sub-menu>

  </el-menu>
  <self-information v-bind:drawer="drawer"></self-information>
</template>

<style scoped>
.flex-grow {
  flex-grow: 1;
}
</style>