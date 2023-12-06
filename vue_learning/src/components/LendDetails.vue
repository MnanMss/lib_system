<script>
import request from "@/until/request";

export default {
  name: "LendDetails_mila",

  data() {
    return {
      dialogFormVisible : false,
      lend: {
        lenDays: 0
      },
      formLabelWidth : '140px'
    }
  },

  mounted() {
    this.lend.customer = JSON.parse(sessionStorage.getItem("user"))
    this.lend.book = JSON.parse(sessionStorage.getItem("nowBook"))
  },
  methods: {
    prepare() {
      this.lend.customer = JSON.parse(sessionStorage.getItem("user"))
      this.lend.book = JSON.parse(sessionStorage.getItem("nowBook"))
    },
    formDate(date) {
      let year = date.getFullYear()
      let month = (date.getMonth() + 1).toString().padStart(2, '0')
      let day = date.getDate().toString().padStart(2, '0')
      return `${year}-${month}-${day}`
    },
    submit() {

      if(this.lend.book.freeNumber === 0) {
        this.$message({
          message: "书籍无剩余",
          type: "error"
        })
        return
      }

      if(this.lend.customer.lendBookNum === 0) {
        this.$message({
          message: "达到借书上限",
          type: "error"
        })
        return
      }

      this.dialogFormVisible = false;
      this.lend.borrowTime = this.formDate(new Date())
      request.post("api/book/lend" , this.lend).then(res=>{
        if(res.data.code === "-1") {
          this.$message({
            message: res.data.msg,
            type: "error"
          })
        }
        else {
          this.$message({
            message: "借阅成功",
            type: "success"
          })
          console.log(res.data.data)
          this.lend = res.data.data
          console.log(this.lend)
          sessionStorage.setItem("user" ,JSON.stringify(this.lend.customer))
          window.location.reload()
        }
      })
    }
  }

}
</script>

<template>
  <!-- Form -->
  <el-button type="primary" @click="dialogFormVisible = true; $emit('myClick')" >
    借阅
  </el-button>

  <el-dialog v-model="dialogFormVisible" title="借书登记" @open="prepare">
    <el-form>
      <el-form-item label="可借书本数" :label-width="formLabelWidth">
        <el-text>{{lend.customer.lendBookNum}}</el-text>
      </el-form-item >
      <el-form-item label="书籍剩余数量" :label-width="formLabelWidth" >
        <el-text>{{lend.book.freeNumber}}</el-text>
      </el-form-item>
      <el-form-item
          label="借书天数"
          :label-width="formLabelWidth"
      >
        <el-input
            v-model.number="lend.lenDays"
            autocomplete="off"
        >
        </el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false;">取消</el-button>
        <el-button type="primary" @click="submit">
          确认
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped>
.el-button--text {
  margin-right: 15px;
}
.el-select {
  width: 300px;
}
.el-input {
  width: 300px;
}
.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>