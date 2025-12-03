<script setup lang="ts">
import { onMounted, ref } from 'vue'
import PlayerController from '@/components/PlayerController/index.vue'
import Nav from '@/components/Nav.vue'
import FloatingPanel from '@/components/FloatingPanel/index.vue'
import ComprehensiveSearch from './ComprehensiveSearch.vue'

const isOpenPanel = ref(false)
function openSearch() {
  isOpenPanel.value = true
}

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

onMounted(calcHeight)
</script>

<template>
<div class="player-home-container">
  <PlayerController class="player-controller"></PlayerController>
  <Nav class="nav" @openSearch="openSearch"></Nav>

  {{ isOpenPanel }}

  <FloatingPanel v-model:open="isOpenPanel">
    <ComprehensiveSearch></ComprehensiveSearch>
  </FloatingPanel>
</div>
</template>

<style scoped lang="less">

.player-home-container {
  width: 100vw;
  //height: 100vh;
  height: calc(var(--vh, 1vh) * 100);
  background-color: var(--bg-base);
  position: relative;
  //overflow: auto;
  box-sizing: border-box;
  overflow: hidden;

  .player-controller {
    position: absolute;
    right: 0;
    left: var(--gap);
    bottom: var(--gap);
    z-index: 9;
    width: calc(100% - 2 * var(--gap));
  }

  .nav {
    position: absolute;
    right: 10px;
    top: 10px;
  }
}
</style>
