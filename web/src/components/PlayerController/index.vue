<template>
  <div class="controller-wrap">
    <div class="avatar"></div>
    <div class="w-full h-full ml-2">
      <div class="text-size-base text-white font-pf-b">JR-01</div>
      <div class="text-size-sm text-gray-300 mt-1">Tokoy </div>
    </div>
    <div class="right shrink-1">
      <div v-if="isPlay" @click="isPlay = !isPlay" class="iconfont icon-bofang text-white text-size-4xl!"></div>
      <div v-else @click="isPlay = !isPlay" class="iconfont icon-zanting text-white text-size-4xl!"></div>
<!--      <div class="iconfont icon-dianzan-shixin text-white text-size-4xl!"></div>-->
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import PlayerController from './Player.vue'

const playerRef = ref()

const isPlay = ref(false)

const loadAudio = () => {
  playerRef.value?.initPlayer('https://vip1.fhbf9.com/20210705/eoQxrzxS/index.m3u8')
}

</script>


<style lang="less" scoped>
.controller-wrap {
  height:var(--controller-height);
  background-color: #343a40;
  border-radius: 4px;
  padding: 12px;
  box-sizing: border-box;
  display: flex;
  justify-content: flex-start;
  align-items: center;


  .avatar {
    width: var(--avatar-size);
    height: var(--avatar-size);
    background-color: #fff;
    flex-shrink: 0;
  }

  //.center {
  //  width: 100%;
  //  height: 20px;
  //  margin-left: 12px;
  //}

  .right {

  }
}
</style>
