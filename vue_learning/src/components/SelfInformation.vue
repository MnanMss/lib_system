<script>
export default {
  name: "SelfInformation_mila",
  props:['drawer'],
  data() {
    return {
      flag: false
    }
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
        title="Vertical list with border"
        direction="vertical"
        :column="4"
        :size="'medium'"
    >
      <el-descriptions-item label="Username">kooriookami</el-descriptions-item>
      <el-descriptions-item label="Telephone">18100000000</el-descriptions-item>
      <el-descriptions-item label="Place" :span="2">Suzhou</el-descriptions-item>
      <el-descriptions-item label="Remarks">
        <el-tag size="small">School</el-tag>
      </el-descriptions-item>
      <el-descriptions-item label="Address"
      >No.1188, Wuzhong Avenue, Wuzhong District, Suzhou, Jiangsu Province
      </el-descriptions-item>
    </el-descriptions>
    <el-button type="info">修改个人信息</el-button>
    <el-button type="danger">登出</el-button>
  </el-drawer>
</template>

<style scoped>

</style>