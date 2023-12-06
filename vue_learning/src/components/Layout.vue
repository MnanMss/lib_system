<script>
import Header from '@/components/Header.vue'
import Modal from "@/components/Modal.vue";
import store from "@/store"
export default {
  name: "Layout_mila",
  components: {Header , Modal},
  data() {
    return {
      isModalVisible: false
    };
  },
  mounted() {
    let user = JSON.parse(sessionStorage.getItem("user"))
    // 根据条件判断是否显示模态
    if (user.lock === true) {
      this.isModalVisible = true;
      store.commit('setIsModalVisible' , true)
    }
  }
}
</script>

<template>
  <Header></Header>
  <Modal :is-visible="isModalVisible" @update:isVisible="isModalVisible = $event"></Modal>
  <router-view></router-view>
</template>

<style scoped>

</style>