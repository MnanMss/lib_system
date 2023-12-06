import { createApp } from 'vue'
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';  // 引入Element UI样式
import router from './router'
import App from '@/App.vue'
import store from "@/store";


createApp(App).use(ElementPlus).use(router).use(store).mount('#app')
