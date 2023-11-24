<script>
export default {
  name: "ManagementBook_mila",
  data() {
    return {
      books: [
        {
          ISBN: '123456789',
          bookName: 'js实战',
          author: 'xxxx',
          price: 25.2,
          bookCompany: 'ooooooo',
          bookDate: '2023-11-23',
          totalNumber: 50,
          freeNumber: 25
        },
        {
          ISBN: '123456789',
          bookName: 'js实战',
          author: 'xxxx',
          price: 12.2,
          bookCompany: 'ooooooo',
          bookDate: '2023-11-23',
          totalNumber: 234,
          freeNumber: 25
        },
        {
          ISBN: '123456789',
          bookName: 'js实战',
          author: 'xxxx',
          price: 23,
          bookCompany: 'ooooooo',
          bookDate: '2023-11-23',
          totalNumber: 50,
          freeNumber: 1
        },
        {
          ISBN: '123456789',
          bookName: 'js实战',
          author: 'xxxx',
          price: 13,
          bookCompany: 'ooooooo',
          bookDate: '2023-11-23',
          totalNumber: 100,
          freeNumber: 25
        },
        {
          ISBN: '123456789',
          bookName: 'js实战',
          author: 'xxxx',
          price: 232,
          bookCompany: 'ooooooo',
          bookDate: '2023-11-23',
          totalNumber: 323,
          freeNumber: 12
        },
        {
          ISBN: '123456789',
          bookName: 'js实战',
          author: 'xxxx',
          price: 25.2,
          bookCompany: 'ooooooo',
          bookDate: '2023-11-23',
          totalNumber: 50,
          freeNumber: 12
        },
      ]
    }
  }
}
</script>

<template>
  <el-table
      :data="books"
      style="width: 100%"
      :table-layout="'fixed'"
      border>
    <el-table-column type="selection" width="55"/>
    <el-table-column label="书名" prop="bookName"/>
    <el-table-column label="作者" prop="author"/>
    <el-table-column label="价格" sortable prop="price"/>
    <el-table-column label="出版商" prop="bookCompany"/>
    <el-table-column label="出版日期" prop="bookDate"/>
    <el-table-column label="藏馆总数" prop="totalNumber" sortable/>
    <el-table-column label="剩余数量" prop="freeNumber" sortable/>
  </el-table>
</template>

<style scoped>

</style>