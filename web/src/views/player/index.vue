<script setup lang="ts">
import { ref } from 'vue';
import BottomNavBar from '@/components/BottomNavBar.vue';
import PlayerCard from '@/components/PlayerCard.vue';


</script>

<template>
  <div class="phone-container w-full h-full bg-white overflow-hidden relative">
    <!-- 上中部：地图区域 -->
    <div class="relative w-full h-full map-placeholder overflow-hidden">
      <!-- 模拟地图元素 -->
      <div class="absolute inset-0 opacity-10 pointer-events-none">
        <div class="border-b border-gray-400 w-full h-32 top-24 absolute transform rotate-12"></div>
        <div class="border-r border-gray-400 h-full w-32 left-48 absolute transform -rotate-6"></div>
      </div>

      <!-- 电台标记点 -->
      <div class="map-marker" style="top: 120px; left: 80px;"></div>
      <div class="map-marker" style="top: 300px; left: 60px;"></div>
      <div class="map-marker" style="top: 200px; right: 50px;"></div>

      <!-- 当前播放电台标记 (中心位置) -->
      <div class="map-marker map-marker-active" style="top: 50%; left: 50%; transform: translate(-50%, -50%);">
        <div class="absolute -top-10 left-1/2 transform -translate-x-1/2 bg-black text-white text-xs px-3 py-1 rounded-full whitespace-nowrap">Now Playing: Tokyo FM</div>
      </div>
    </div>


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
