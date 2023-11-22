<script >
import {Clock, Timer} from "@element-plus/icons-vue";

export default {
  name: 'Rend_mila',
  components: {Clock, Timer},
  data() {
    return{
      tableData:[
        {
          date: '2023-11-22',
          bookName: 'js实战',
          address: 'No. 189, Grove St, Los Angeles',
          resTime: 10
        },
        {
          date: '2023-11-11',
          bookName: 'headfirst-java',
          address: 'No. 189, Grove St, Los Angeles',
          resTime: 10
        },
        {
          date: '2023-10-04',
          bookName: '高数',
          address: 'No. 189, Grove St, Los Angeles',
          resTime: 10
        },
        {
          date: '2016-05-01',
          bookName: '英语',
          address: 'No. 189, Grove St, Los Angeles',
          resTime: 10
        },
      ]
    }
  },
  methods: {
    handleEdit(index , row) {
      console.log(index, row)
    },
    handleDelete(index , row) {
      console.log(index, row)
    },
    deadline(preDate , addDays) {
      const date = new Date(preDate)
      date.setDate(date.getDate() + addDays)
      return date.toISOString().split('T')[0]
    }
  }
}

</script>

<template>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column label="借阅时间" width="180">
      <template #default="scope">
        <div style="display: flex; align-items: center">
          <el-icon><timer /></el-icon>
          <span style="margin-left: 10px">{{ scope.row.date }}</span>
        </div>
      </template>
    </el-table-column>
    <el-table-column label="书名" width="180">
      <template #default="scope">
        <el-popover  trigger="hover" placement="top" width="auto">
          <template #default>
            <div> bookName: {{ scope.row. bookName }}</div>
            <div>address: {{ scope.row.address }}</div>
          </template>
          <template #reference>
            <el-tag>{{ scope.row. bookName }}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>

    <el-table-column label="剩余天数" width="180">

      <template #default="scope">
        <el-icon><clock /></el-icon>
        <el-popover placement="top" width="auto" trigger="hover">
          <template #default>
            <div>还书截至日期: {{deadline(scope.row.date , scope.row.resTime)}}</div>
          </template>
          <template #reference>
            <el-tag effect="light" round>{{scope.row.resTime}}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>

    <el-table-column label="操作">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
        >归还</el-button
        >
        <el-button
            size="small"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
        >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
</template>

<style scoped>

</style>