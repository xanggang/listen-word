<script setup lang="ts">
import { ref } from 'vue';
import Map from '@/components/Map.vue'
import { getStationById } from '@/api'
import { usePlayerStore } from '@/stores/counter.ts'

const playerStore = usePlayerStore()


async function handleChange(data: any) {
  // const res = await getStationById(data.id)
  playerStore.handlePlayerStation(data)
}
</script>

<template>
  <div class="phone-container w-full h-full bg-white overflow-hidden relative">
    <Map @change="handleChange"> </Map>
  </div>
</template>

<style scoped>
/* 模拟地图背景图案 */
.map-placeholder {
  background-color: #e5e7eb; /* gray-200 */
  background-image:
          linear-gradient(45deg, #d1d5db 25%, transparent 25%, transparent 75%, #d1d5db 75%, #d1d5db),
          linear-gradient(45deg, #d1d5db 25%, transparent 25%, transparent 75%, #d1d5db 75%, #d1d5db);
  background-size: 64px 64px;
  background-position: 0 0, 32px 32px;
}

/* CSS绘制的图标形状 */
.icon-play {
  width: 0; height: 0;
  border-top: 12px solid transparent;
  border-bottom: 12px solid transparent;
  border-left: 20px solid white;
}

.icon-pause {
  width: 20px; height: 24px;
  border-left: 6px solid white;
  border-right: 6px solid white;
}

.icon-list-black {
  width: 24px; height: 24px;
  background: linear-gradient(to bottom, black 4px, transparent 4px, transparent 8px, black 8px, transparent 12px, black 16px, transparent 20px);
}

/* 地图标记点 */
.map-marker {
  width: 24px; height: 24px; background-color: black; border: 4px solid white; border-radius: 50%; position: absolute; box-shadow: 0 4px 6px rgba(0,0,0,0.3);
}

.map-marker-active {
  width: 32px; height: 32px; background-color: white; border: 6px solid black; z-index: 10;
}
</style>
