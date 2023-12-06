<script>
import { ElNotification } from 'element-plus';
export default {
  name: "Modal_mila",
  props: {
    isVisible: Boolean
  },
  methods: {
    closeModal() {
      // 这里可以放置你的逻辑，当逻辑返回 true时，通知父组件关闭模态
      this.$emit('update:isVisible', false);
    }
  },
  mounted() {
    let user = JSON.parse(sessionStorage.getItem("user"))
    if(user.lock) {
      ElNotification({
        title: "账号锁定",
        message: "逾期未还，支付罚金。否则锁定所有功能",
        duration: 0,
        showClose: false,
        type: "error"
      })
    }
  }
}
</script>

<template>
  <div v-if="isVisible" class="modal">
    <el-text>逾期未还，支付罚金</el-text>
    <el-text>支付页面....</el-text>
    <button @click="closeModal">关闭</button>
  </div>
</template>

<style scoped>
.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>