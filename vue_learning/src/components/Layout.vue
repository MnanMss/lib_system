<script>
import Header from '@/components/Header.vue'
export default {
  name: "Layout_mila",
  components: {Header},
  component: Header
}
</script>

<template>
  <Header></Header>
  <router-view></router-view>
</template>

<style scoped>

</style>