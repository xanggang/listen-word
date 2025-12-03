import { fileURLToPath, URL } from 'node:url'
import UnoCSS from 'unocss/vite'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueJsx from '@vitejs/plugin-vue-jsx'
// import vueDevTools from 'vite-plugin-vue-devtools'
// import postCssPxToRem from 'postcss-pxtorem'
import postcssPresetEnv from 'postcss-preset-env'
import autoprefixer from 'autoprefixer'


// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueJsx(),
    // vueDevTools(),
    UnoCSS(),
  ],
  css: {
    postcss: {
      plugins: [
        postcssPresetEnv({}), // 使用最新的 CSS 特性
        autoprefixer({}), // 自动添加浏览器前缀
        // postCssPxToRem({
        //   rootValue: 100, // 1rem = 16px
        //   propList: ['*'],
        // })
      ]
    }
  },
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
  server: {
    port: 5173,
    host: true,
  },
})
