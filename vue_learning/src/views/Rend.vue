<script >
import {Clock, InfoFilled, Timer} from "@element-plus/icons-vue";
import request from '@/until/request'
export default {
  name: 'Rend_mila',
  computed: {
    InfoFilled() {
      return InfoFilled
    }
  },
  components: {Clock, Timer},
  data() {
    return{
      tableData:[],
      visible: false,
    }
  },
  methods: {
    handleDelete(index , row) {
      console.log(index)
      console.log(row)
      this.tableData.splice(index , 1)
      request.post("api/book/deleteRecord" , row)
    },
    formDate(date) {
      let year = date.getFullYear()
      let month = (date.getMonth() + 1).toString().padStart(2, '0')
      let day = date.getDate().toString().padStart(2, '0')
      return `${year}-${month}-${day}`
    },
    handleReturn(record) {
      record.returnTime = this.formDate(new Date)
      request.post("api/book/returnBook" , record).then(res=>{
        sessionStorage.setItem("user" , JSON.stringify(res.data.data.customer))
      })
    },
    deadline(preDate , addDays) {
      const date = new Date(preDate)
      date.setDate(date.getDate() + addDays)

      return date.toISOString().split('T')[0]
    },
    calculateDaysBetweenDates(record) {
      const date1 = new Date(record.borrowTime) // 借书时间
      const date2 = new Date() // 当前时间
      const oneDayInMs = 24 * 60 * 60 * 1000; // 一天的毫秒数
      const timeDiff = date2.getTime() - date1.getTime(); // 时间差的绝对值
      let days = parseInt(record.lenDays) - timeDiff / oneDayInMs
      if(timeDiff <= 0) {
        record.overdue = true
        days = 0
      }else record.overdue = false
      record.resDays = days
      return Math.ceil(days); // 向上取整得到相差的天数
    },
    handleRenew(record) {
      request.put("api/book/renewBook" , record).then(res=>{
        record = res.data.data
      })
      console.log(record)
      window.location.reload()
    }
  },
  mounted() {
    let user  = JSON.parse(sessionStorage.getItem("user"))
    request.post("api/book/record" , user).then(res=> {
      this.tableData = res.data.data
    })
  }
}

</script>

<template>
  <el-table :data="tableData"  :table-layout="'fixed'" style="width: 100%">x
    <el-table-column label="借阅时间" width="180">
      <template #default="scope">
        <div>
          <el-icon><timer /></el-icon>
          <span>{{ scope.row.borrowTime }}</span>
        </div>
      </template>
    </el-table-column>
    <el-table-column label="书名" >
      <template #default="scope">
        <el-popover  trigger="hover" placement="top" width="auto">
          <template #default>
            <div> bookName: {{ scope.row.book.bookName }}</div>
            <div>author: {{ scope.row.book.author }}</div>
          </template>
          <template #reference>
            <el-tag>{{ scope.row.book.bookName }}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>

    <el-table-column label="剩余天数" >

      <template #default="scope">
        <el-icon><clock /></el-icon>
        <el-popover placement="top" width="auto" trigger="hover">
          <template #default>
            <div>还书截至日期: {{deadline(scope.row.borrowTime , scope.row.lenDays)}}</div>
          </template>
          <template #reference>
            <el-tag effect="light" round>{{calculateDaysBetweenDates(scope.row)}}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>

    <el-table-column label="状态">
      <template #default="scope">
        <el-tag effect="light" type="error" v-if="(scope.row.overdue) && scope.row.returnTime === null">逾期</el-tag>
        <el-tag effect="light" type="warning" v-else-if="scope.row.returnTime === null">待还</el-tag>
        <el-tag effect="light" type="success" v-else>已还</el-tag>
      </template>
    </el-table-column>

    <el-table-column fixed="right" label="操作" width="120">
      <template #default="scope">
        <el-button link :type="scope.row.returnTime ? 'danger' : 'success' " @click="handleReturn(scope.row)"  :disabled="scope.row.returnTime != null"
        >归还</el-button
        >
        <el-popconfirm
            v-if="scope.row.returnTime === null"
            :icon="InfoFilled"
            :title="'每次续借15天,最高借书31天;可续借次数:' + scope.row.renewTime"
            @confirm="handleRenew(scope.row)">
          <template #reference>
            <el-button link type="primary" :disabled="scope.row.overdue">续借</el-button>
          </template>
        </el-popconfirm>
        <el-popconfirm v-else title="确认删除" @confirm="handleDelete(scope.$index , scope.row)">
          <template #reference>
            <el-button link type="danger">删除</el-button>
          </template>
        </el-popconfirm>
      </template>
    </el-table-column>

  </el-table>
</template>

<style scoped>

</style>