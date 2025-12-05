<!-- src/components/LeaderboardItem.vue -->
<script setup lang="ts">
import { formatNumber } from '@/utils/utils'
import type { Station } from '@/api'

interface Props {
  item: Station
  index: number
}

defineProps<Props>()

const emits = defineEmits<{ (e: 'play', item: Station): void }>()

const handlePlay = (item: Station) => {
  emits('play', item)
}
</script>

<template>
  <div class="task-card bg-white border-b border-gray-100">
    <div class="text-center flex-shrink-0 mr-4 text-lg font-medium text-gray-400 w-10">
      {{ item.rank }}
    </div>

    <div class="mr-4 flex-shrink-0 w-10 h-10 rounded-full">
      <img v-if="item.favicon" :src="item.favicon" alt="" class="w-full h-full object-cover rounded-full">
    </div>

    <div class="flex-grow">
      <h3 class="font-bold text-black break-words">{{ item.name }}</h3>
      <p class="text-xs text-gray-500">{{ item.country }} • {{ item.language }}</p>
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
