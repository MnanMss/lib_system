<script>
export default {
  name: "BookList_mila",
  data() {
    return {
      books: [
        {
          image: "https://pic.52112.com/180904/EPS-180904_48/qvz5MLSAHj_small.jpg",
          title: "js实战",
          summary: "ooooooo",
        },
        {
          image: "https://pic.52112.com/180904/EPS-180904_48/qvz5MLSAHj_small.jpg",
          title: "js实战",
          summary: "ooooooo",
        },
        {
          image: "https://pic.52112.com/180904/EPS-180904_48/qvz5MLSAHj_small.jpg",
          title: "js实战",
          summary: "ooooooo",
        },
        {
          image: "https://pic.52112.com/180904/EPS-180904_48/qvz5MLSAHj_small.jpg",
          title: "js实战",
          summary: "ooooooo",
        },
        {
          image: "https://pic.52112.com/180904/EPS-180904_48/qvz5MLSAHj_small.jpg",
          title: "js实战",
          summary: "ooooooo",
        },
        {
          image: "https://pic.52112.com/180904/EPS-180904_48/qvz5MLSAHj_small.jpg",
          title: "js实战",
          summary: "ooooooo",
        },
        {
          image: "https://pic.52112.com/180904/EPS-180904_48/qvz5MLSAHj_small.jpg",
          title: "js实战",
          summary: "ooooooo",
        },
        {
          image: "https://pic.52112.com/180904/EPS-180904_48/qvz5MLSAHj_small.jpg",
          title: "js实战",
          summary: "ooooooo",
        },
      ],
      totalBooks: 10
    }
  }

}
</script>

<template>
  <div class="search-bar">
    <el-input placeholder="搜索图书" v-model="searchQuery" />
  </div>
  <el-row :gutter="20">
    <el-col :xs="12" :sm="6"  v-for="book in books" :key="book.id">
      <el-card class="book-card">
        <div class="image-container">
          <img :src="book.image" alt="Book Cover" />
        </div>
        <div style="padding: 14px;">
          <h3>{{ book.title }}</h3>
          <p>{{ book.summary }}</p>
          <el-button type="text">图书详情</el-button>
          <el-button type="primary">借阅</el-button>
        </div>
      </el-card>
    </el-col>
  </el-row>
  <el-pagination
      background
      layout="prev, pager, next"
      :total="totalBooks"
  ></el-pagination>
</template>

<style scoped>
.book-card {
  max-width: 300px;
  margin: 10px 0 10px 0;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  transition: 0.3s;
  cursor: pointer;
}

.book-card:hover {
  box-shadow: 0 4px 20px 0 rgba(0, 0, 0, 0.2);
}

.image-container img {
  width: 100%;
  height: auto;
  display: block;
}
.search-bar {
  margin-bottom: 20px; /* 为搜索栏和卡片列表之间添加一些空间 */
}
</style>