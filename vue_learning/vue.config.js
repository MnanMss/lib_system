const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      // 对以'/api'开头的请求进行代理
      '/api': {
        // 将请求目标指定到接口服务地址
        target: 'http://localhost:9090',
        changeOrigin:true
      }
    }
  }
})
