<script setup lang="ts">

const emits = defineEmits(['openSearch'])

function handleOpenSearch() {
  emits('openSearch')
}
</script>

<template>
  <div class="nav-container">
    <div class="nav">
      <div class="iconfont icon-a-reqiqiu1 text-white"></div>
    </div>
    <div class="nav">
      <div class="iconfont icon-dingwei text-white"></div>
    </div>
    <div class="nav">
      <div class="iconfont icon-shezhi text-white"></div>
    </div>
    <div class="nav" @click="handleOpenSearch">
      <div class="iconfont icon-sousuo text-white"></div>
    </div>
  </div>
</template>

<style scoped lang="less">

.nav-container {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;

  .nav {
    width: 3rem;
    height: 3rem;
    border-radius: 50%;
    background-color: var(--oc-gray-7);
    display: flex;
    justify-content: center;
    align-items: center;
    margin-bottom: 12px;
    color: #fff;
    cursor: pointer;

    .iconfont {
      font-size: 1.7rem;
    }
  }
}
</style>
