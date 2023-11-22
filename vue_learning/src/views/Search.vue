<script setup>
import { ElInput, ElIcon } from 'element-plus';
import { Search } from '@element-plus/icons-vue';
import {defineComponent , ref} from "vue";

const input = ref('')

defineComponent({
  name: 'Search_mila'
})
</script>

<template>
  <div class="search-container">
    <el-input v-model="input" placeholder="请输入搜索内容" prefix-icon="el-icon-search">
      <template #prefix>
        <el-icon>
          <search />
        </el-icon>
      </template>
    </el-input>
  </div>
</template>

<style scoped>
.search-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 80vh; /* 使用视口高度使其垂直居中 */
}

.el-input {
  max-width: 600px; /* 限制搜索框的最大宽度 */
  border-radius: 22px; /* 使输入框边缘变得圆润 */
}

.el-input__inner {
  border-radius: 22px; /* 使输入框内部边缘变得圆润 */
  height: 44px; /* 设置输入框高度 */
  padding: 0 16px; /* 设置内部填充 */
}

.el-input__prefix {
  margin-right: 8px; /* 设置前缀图标和输入框的间距 */
}

.el-icon {
  color: #909399; /* 设置图标颜色 */
}
</style>