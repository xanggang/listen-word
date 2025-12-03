import { globalIgnores } from 'eslint/config'
import { defineConfigWithVueTs, vueTsConfigs } from '@vue/eslint-config-typescript'
import pluginVue from 'eslint-plugin-vue'
import skipFormatting from '@vue/eslint-config-prettier/skip-formatting'

// To allow more languages other than `ts` in `.vue` files, uncomment the following lines:
// import { configureVueProject } from '@vue/eslint-config-typescript'
// configureVueProject({ scriptLangs: ['ts', 'tsx'] })
// More info at https://github.com/vuejs/eslint-config-typescript/#advanced-setup

export default defineConfigWithVueTs(
  {
    name: 'app/files-to-lint',
    files: ['**/*.{ts,mts,tsx,vue}'], // 匹配需要检查的文件
  },
  vueTsConfigs.recommended, // 推荐的 TypeScript 配置
  pluginVue.configs['flat/essential'], // Vue 的基础规则
  {
    rules: {
      'vue/multi-word-component-names': 'off', // 关闭多词组件名称限制
      '@typescript-eslint/no-explicit-any': 'off', // 允许使用 any 类型
    },
  },
  skipFormatting // 跳过格式化规则冲突
);
