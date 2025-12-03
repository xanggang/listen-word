<script setup lang="ts">
import { ref } from 'vue'

// 定义props
interface Props {
  stationName: string
  stationInfo: string
  coverColor?: string
  isPlaying?: boolean
  isFavorite?: boolean
  isExpanded?: boolean
}

const props = withDefaults(defineProps<Props>(), {
  coverColor: 'var(--oc-green-4)', // 使用项目中的绿色变量
  isPlaying: false,
  isFavorite: false,
  isExpanded: true,
})

// 定义emits
const emit = defineEmits<{
  playPause: []
  toggleFavorite: []
  toggleVolume: []
  showMore: []
  'toggle-expand': []
}>()

// 本地状态
const isVolumeOn = ref(true)

// 事件处理
const handlePlayPause = () => {
  emit('playPause')
}

const handleToggleFavorite = () => {
  emit('toggleFavorite')
}

const handleToggleVolume = () => {
  isVolumeOn.value = !isVolumeOn.value
  emit('toggleVolume')
}

const handleShowMore = () => {
  emit('showMore')
}

const handleToggleExpand = () => {
  emit('toggle-expand')
}
</script>

<template>
  <!-- 下部分：播放器控件 -->
  <div
    class="player-controls-wrap "
    @click11="handleToggleExpand"
    :class="isExpanded ? 'expanded' : 'collapsed'"
  >
    <!-- 展开状态：完整播放器卡片 -->
    <transition>
      <div
        v-if="props.isExpanded"
        @click="handleToggleExpand"
        class="player-card flex items-center p-3 bg-white rounded-xl shadow-sm"
      >
        <!-- 封面区域 -->
        <div class="cover-container mr-4 rounded-xl" :style="{ backgroundColor: props.coverColor }">
          <div class="cover h-16 w-16 "></div>
        </div>

        <!-- 电台信息 -->
        <div class="info flex-1 min-w-0">
          <h3 class="station-name font-medium text-black truncate">{{ props.stationName }}</h3>
          <p class="station-info text-sm text-gray-600">{{ props.stationInfo }}</p>
        </div>

        <!-- 控制按钮 -->
        <div class="controls-wrap space-y-2">
          <div class="controls flex center space-x-2">
            <!-- 喜爱按钮 -->
            <div
              class="button favorite-button flex items-center justify-center text-gray-500 bg-gray-100 text-xl"
              @click="handleToggleFavorite"
              aria-label="Favorite"
            >
              <span v-if="!props.isFavorite" class="iconfont icon-dianzan-xiankuang"></span>
              <span
                v-else
                class="iconfont icon-dianzan-shixin"
                :class="{ active: props.isFavorite }"
              ></span>
            </div>

            <!-- 音量按钮 -->
            <div
              class="button flex items-center justify-center text-gray-500 bg-gray-100 text-xl"
              @click="handleToggleVolume"
              aria-label="Volume"
            >
              <div v-if="isVolumeOn" class="iconfont icon-jingyin"></div>
              <div v-else class="iconfont icon-yinliang"></div>
            </div>
          </div>

          <div class="controls flex center space-x-2">
            <!-- 播放/暂停按钮 -->
            <div
              class="button play-button flex items-center justify-center text-gray-500 bg-gray-100 rounded-full"
              @click="handlePlayPause"
              aria-label="Play/Pause"
            >
              <div v-if="props.isPlaying" class="iconfont icon-bofang text-xl"></div>
              <div v-else class="iconfont icon-zanting text-xl"></div>
            </div>

            <!-- 更多选项按钮 -->
            <div
              class="button flex items-center justify-center text-gray-500 bg-gray-100 text-xl"
              @click="handleShowMore"
              aria-label="More Options"
            >
              <div class="iconfont icon-danmushezhi"></div>
            </div>
          </div>
        </div>
      </div>

      <!-- 收起状态：仅播放按钮 -->
      <div v-else class="controls flex items-center justify-center w-full h-full">
        <div
          class="button play-button w-12 h-12 flex items-center justify-center text-white bg-primary-1 rounded-full"
          @click="emit('toggle-expand')"
          aria-label="Toggle Expand"
        >
          <div v-if="props.isPlaying" class="iconfont icon-bofang text-xl"></div>
          <div v-else class="iconfont icon-zanting text-xl"></div>
        </div>
      </div>

    </transition>
  </div>
</template>

<style scoped lang="less">

.player-controls-wrap {
  position: absolute;
  border-radius: 0.75rem;
  box-shadow: 0 -4px 20px rgba(0,0,0,0.1);
  bottom: 6rem;
  height: 6rem;
  right: 2%;
  //background: white;

  &.expanded {
    width: 96%;
    height: 6rem;
    transition: all 0.4s;
    //background-color: var(--primary-1);
    //transition:
    //  width 0.6s cubic-bezier(0.68, -0.55, 0.27, 1.55) 0s,
    //  height 0.6s cubic-bezier(0.68, -0.55, 0.27, 1.55) 0.6s,
    //  border-radius 0.1s ease 1.2s;
  }

  &.collapsed {
    border-radius: 50%;
    width: 3rem;
    height: 3rem;
    background-color: var(--primary-1);

    transition:
      border-radius 0s ease 0.3s,
      height 0.3s ease 0s,
      width 0.3s ease 0s;
  }
}

.station-name {
  font-size: var(--text-size-xl);
  line-height: 1.5;
}

.station-info {
  font-size: var(--text-size-base);
  line-height: 1.5;
}

.controls {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;

  .button {
    border-radius: 50%;
    width: 2rem;
    height: 2rem
  }

  .play-button {
    background-color: var(--primary-1);
    color: #fff;
  }

  .favorite-button {
    .active {
      color: var(--primary-1);
    }
  }
}
</style>
