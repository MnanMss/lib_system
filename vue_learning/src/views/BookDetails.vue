<script>
import lend from '@/components/LendDetails.vue'
export default {
  name: "BookDetails_mila",
  components: {
    lend: lend
  },
  mounted() {
    this.book = JSON.parse(sessionStorage.getItem("nowBook"))
  },
  data() {
    return {
      book: {}
    }
  }
}
</script>

<template>
  <div class="layout-container">
    <!-- 上半部分，两个并列的卡片 -->
    <el-row :gutter="20" class="top-row">
      <el-col :span="6">
        <el-card shadow="hover">
          <el-image :src="book.imgSrc"></el-image>
        </el-card>
      </el-col>
      <el-col :span="16" class="second-card">
        <el-card shadow="hover">
          <el-row>
            <el-col>书名：{{book.bookName}}</el-col>
          </el-row>
          <el-row>
            <el-col>作者：{{book.author}}</el-col>
          </el-row>
          <el-row>
            <el-col>出版社：{{book.bookCompany}}</el-col>
          </el-row>
          <el-row>
            <el-col>价格：{{book.price}}</el-col>
          </el-row>
          <el-row>
            <el-col>出版日：{{book.publishDate}}</el-col>
          </el-row>
          <el-row>
            <el-col>书籍描述：{{book.description}}</el-col>
          </el-row>
          <el-row>
            <el-col>剩余数量：{{book.freeNumber}}</el-col>
          </el-row>
          <el-row>
            <el-col>馆藏数量：{{book.totalNumber}}</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <lend></lend>
<!--    &lt;!&ndash; 下半部分，一个宽度更大的卡片 &ndash;&gt;-->
<!--    <el-card shadow="hover" class="large-card">-->
<!--      <div class="content">评论，图书目录</div>-->
<!--    </el-card>-->

    <!-- 右下角的按钮 -->

  </div>
</template>

<style scoped>
.layout-container {
  position: relative;
  padding: 40px;
  margin-left: 50px;
  min-height: 80vh; /* Minimum height to ensure that the button can be absolutely positioned within the container */
}

.top-row {
  margin-bottom: 20px; /* Spacing between top cards and large card */
}

.second-card {
  offset: 0 0 0 20px; /* Slight offset to ensure gutter between cards */
}

.large-card {
  position: absolute;
  bottom: 60px; /* Position from bottom */
  left: 40px; /* Position from left */
  right: 120px; /* Position from right to stretch across the container */
}

.action-button {
  position: fixed; /* 固定定位，悬浮效果 */
  right: 40px; /* 距离视口右侧的距离 */
  bottom: 100px; /* 距离视口底部的距离 */
  z-index: 1000; /* 确保按钮在其他内容之上 */
}

.content {
  padding: 20px;
  font-size: 14px;
  color: #333;
}

/* Adjustments for responsive behavior */
@media (max-width: 768px) {
  .large-card,
  .action-button {
    left: 20px;
    right: 20px;
  }

  .second-card {
    offset: 0;
  }

  .top-row {
    display: flex;
    flex-direction: column;
  }

  .top-row .el-col {
    margin-bottom: 20px;
  }
}
</style>