<script setup lang="ts">
import BottomNavBar from '@/components/BottomNavBar.vue'
import { onMounted, ref } from 'vue'
import PlayerCard from '@/components/PlayerCard.vue'
import { getLanguages } from '@/api'

function calcHeight() {
  //首先我们获得视口高度并将其乘以1%以获得1vh单位的值
  const vh = window.innerHeight * 0.01
  // 然后，我们将——vh自定义属性中的值设置为文档的根
  document.documentElement.style.setProperty('--vh', `${vh}px`)

// 我们监听resize事件 视图大小发生变化就重新计算1vh的值
  window.addEventListener('resize', () => {
    // 我们执行与前面相同的脚本
    const vh = window.innerHeight * 0.01
    document.documentElement.style.setProperty('--vh', `${vh}px`)
  })
}

// 播放状态
const isPlaying = ref(true);
const isFavorite = ref(false);
// 播放器展开/收起状态
const isExpanded = ref(true);

// 切换播放/暂停状态
const togglePlayPause = () => {
  isPlaying.value = !isPlaying.value;
};

// 切换喜爱状态
const toggleFavorite = () => {
  isFavorite.value = !isFavorite.value;
};

// 切换音量
const toggleVolume = () => {
  console.log('Toggle volume');
};

// 显示更多选项
const showMoreOptions = () => {
  console.log('Show more options');
};

// 切换播放器展开/收起状态
const toggleExpand = () => {
  isExpanded.value = !isExpanded.value;
};

onMounted(calcHeight)

// getLanguages()
</script>

<template>
  <div class="app-root">
    <div class="app-center">
      <router-view v-slot="{ Component, route }">
        <transition
          mode="out-in"
        >
          <component :is="Component" :key="route.path"></component>
        </transition>
      </router-view>
    </div>

    <!-- 下部分：播放器控件 -->
    <PlayerCard
      station-name="Harmonia FM - Berlin"
      station-info="Electronic • Germany"
      :is-playing="isPlaying"
      :is-favorite="isFavorite"
      :is-expanded="isExpanded"
      @play-pause="togglePlayPause"
      @toggle-favorite="toggleFavorite"
      @toggle-volume="toggleVolume"
      @show-more="showMoreOptions"
      @toggle-expand="toggleExpand"
    />

    <BottomNavBar></BottomNavBar>
  </div>
</template>

<style lang="less">
// @import "//at.alicdn.com/t/c/font_5062332_f783hv8wzu.css";

#app {
  width: 100%;
  height: calc(var(--vh, 1vh) * 100);
  overflow: hidden;
}

.app-root {
  width: 100vw;
  height: 100%;
  display: flex;
  flex-direction: column;
  position: relative;

  .app-center {
    width: 100%;
    height: 100%;
    padding-bottom: 4rem;
  }
}
</style>
