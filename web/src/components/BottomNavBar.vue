<script setup lang="ts">
import { computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useI18n } from 'vue-i18n'

const route = useRoute()
const router = useRouter()
const { t } = useI18n()

// 计算当前激活的导航项
const activeNav = computed(() => {
  const path = route.path
  if (path === '/player') return 'player'
  if (path === '/discover') return 'discover'
  if (path === '/leaderboard') return 'leaderboard'
  if (path === '/settings') return 'settings'
  return 'player' // 默认选中播放器
})

// 导航到对应页面
const navigateTo = (page: string) => {
  router.push(`/${page}`)
}
</script>

<template>
  <div
    class="fixed bottom-0 left-0 w-full h-16 bg-white border border-gray-100 flex items-center justify-around px-2 z-50"
  >
    <div
      class="flex flex-col items-center justify-center w-16 h-full cursor-pointer"
      :class="{ 'opacity-50': activeNav !== 'player' }"
      @click="navigateTo('player')"
    >
      <div
        class="iconfont icon-reqiqiu text-2xl"
        :class="{ 'border-black': activeNav === 'player' }"
      ></div>

      <span
        class="text-[10px] font-medium text-black leading-tight"
        :class="{ 'font-bold': activeNav === 'player' }"
        >{{ t('nav.player') }}</span>
    </div>

    <div
      class="flex flex-col items-center justify-center w-16 h-full cursor-pointer"
      :class="{ 'opacity-50': activeNav !== 'discover' }"
      @click="navigateTo('discover')"
    >
      <div
        class="iconfont icon-sousuo3 text-2xl"
        :class="{ 'border-black': activeNav === 'discover' }"
      ></div>
      <span
        class="text-[10px] font-medium text-black leading-tight"
        :class="{ 'font-bold': activeNav === 'discover' }"
        >{{ t('nav.discover') }}</span>
    </div>

    <div
      class="flex flex-col items-center justify-center w-16 h-full cursor-pointer"
      :class="{ 'opacity-50': activeNav !== 'leaderboard' }"
      @click="navigateTo('leaderboard')"
    >
      <div
        class="iconfont icon-paixing text-2xl"
        :class="{ 'border-black': activeNav === 'leaderboard' }"
      ></div>
      <span
        class="text-[10px] font-medium text-black leading-tight"
        :class="{ 'font-bold': activeNav === 'leaderboard' }"
        >{{ t('nav.leaderboard') }}</span>

    </div>

    <div
      class="flex flex-col items-center justify-center w-16 h-full cursor-pointer"
      :class="{ 'opacity-50': activeNav !== 'settings' }"
      @click="navigateTo('settings')"
    >
      <div
        class="iconfont icon-shezhi1 text-2xl"
        :class="{ 'border-black': activeNav === 'settings' }"
      ></div>
      <span
        class="text-[10px] font-medium text-black leading-tight"
        :class="{ 'font-bold': activeNav === 'settings' }"
        >{{ t('nav.settings') }}</span>
    </div>
  </div>
</template>

<style scoped>

.border {
  border-top: 1px solid var(--bdc-disabled);
}
</style>
