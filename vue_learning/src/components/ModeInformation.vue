<script>
export default {
  name: "ModeInformation_mila",
  data() {
    return {
      dialogFormVisible: false,
      form: {
        username: '',
        password: '',
        sex: '',
        phone: '',
        address: ''
      }
    }
  }
}
</script>

<template>
  <el-button type="info" @click="dialogFormVisible = true">修改个人信息</el-button>

  <el-dialog v-model="dialogFormVisible" title="提交修改">
    <el-form :model="form">
      <el-form-item label="用户名"></el-form-item>
    </el-form>
  </el-dialog>
</template>

<style scoped>

</style>