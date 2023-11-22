<script>
export default {
  name: "element_mi",
  data() {
    return {
      count: 0
    }
  },
  methods: {
    clickButton() {
      this.count++;
    }
  }

}
</script>

<template>
  <div style="text-align: center">
    <div style="margin: 40px"><el-tag>这里是模板内容：{{count}}次点击</el-tag></div>
    <div><el-button @click="clickButton">按钮</el-button></div>
    <hr/>
    <el-button>默认按钮</el-button>
    <el-button size="medium">中等按钮</el-button>
    <el-button size="small">小型按钮</el-button>
    <el-button size="mini">超小按钮</el-button>
    <hr/>
    <el-button type="primary">常规按钮</el-button>
    <el-button type="success">成功按钮</el-button>
    <el-button type="info">信息按钮</el-button>
    <el-button type="warning">警告按钮</el-button>
    <el-button type="danger">危险按钮</el-button>
    <hr/>
    <el-button type="primary" :plain="true">描边</el-button>
    <el-button type="primary" :round="true">圆角</el-button>
    <el-button type="primary" :circle="true">圆形</el-button>
    <el-button type="primary" :disable="true">禁用</el-button>
    <el-button type="primary" :loading="true">加载</el-button>
  </div>


</template>

<style scoped>

</style>