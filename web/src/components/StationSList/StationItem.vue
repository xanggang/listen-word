<!-- src/components/LeaderboardItem.vue -->
<script setup lang="ts">
import { formatNumber } from '@/utils/utils'
import type { Station } from '@/api'
import { usePlayerStore } from '@/stores/counter.ts'
import { ref } from 'vue'

const playerStore = usePlayerStore()

interface Props {
  item: Station
}

defineProps<Props>()

const handlePlay = (item: Station) => {
  playerStore.handlePlayerStation( item)
}

</script>

<template>
  <div class="flex items-center p-3 bg-white border border-gray-100 rounded-2xl shadow-lg cursor-pointer">
    <div class="w-16 h-16 rounded-xl mr-4 flex-shrink-0">
      <img v-if="item.favicon" :src="item.favicon" alt="" class="w-full h-full object-cover rounded-full">
    </div> <!-- Placeholder for station logo -->
    <div class="flex-grow">
      <h3 class="font-bold text-black leading-6 text-xl break-words">{{ item.name }}</h3>
      <p class="text-sm text-gray-700 leading-5 text-lg">{{ item.country }} • {{ item.language }}</p>
    </div>
    <div class="text-right flex items-center flex-shrink-0">
      <div class="font-bold text-black mr-3">{{ formatNumber(item.votes) }}</div>
      <van-button
          round
          icon="play"
          size="small"
          type="primary"
          @click="handlePlay(item)"
      />
    </div>
  </div>
</template>

<style scoped lang="less">
.task-card {
  display: flex;
  @apply items-center pt-4 pb-4;
}

.break-words {
  word-break: break-word;
  overflow-wrap: break-word;
}
</style>
