<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue'
import * as Tone from 'tone'

// 播放器状态
const isPlaying = ref(false)
const currentTime = ref(0)
const duration = ref(0)
const volume = ref(0.5)
const playbackRate = ref(1)
const progress = ref(0)

// Tone.js 相关实例
let player: Tone.Player | null = null
let volumeNode: Tone.Volume | null = null
let intervalId: number | null = null

// 初始化播放器
const initPlayer = async (audioUrl: string) => {
  try {
    // 创建音量控制节点
    volumeNode = new Tone.Volume(volume.value).toDestination()

    // 创建播放器
    player = new Tone.Player({
      url: audioUrl,
      onload: () => {
        duration.value = player?.buffer.duration || 0
      },
      onend: () => {
        isPlaying.value = false
        currentTime.value = 0
        progress.value = 0
      }
    }).connect(volumeNode)

    // 监听播放进度
    startProgressTracking()
  } catch (error) {
    console.error('Failed to initialize player:', error)
  }
}

// 开始追踪播放进度
const startProgressTracking = () => {
  if (intervalId) clearInterval(intervalId)

  intervalId = window.setInterval(() => {
    if (player && isPlaying.value) {
      currentTime.value = player.now() - (player.startTime || 0)
      progress.value = (currentTime.value / duration.value) * 100
    }
  }, 100)
}

// 播放控制方法
const play = async () => {
  if (!player) return

  if (Tone.context.state !== 'running') {
    await Tone.context.resume()
  }

  if (player.loaded) {
    player.start()
    isPlaying.value = true
  }
}

const pause = () => {
  if (player) {
    player.stop()
    isPlaying.value = false
  }
}

const stop = () => {
  if (player) {
    player.stop()
    isPlaying.value = false
    currentTime.value = 0
    progress.value = 0
  }
}

// 跳转到指定时间
const seekTo = (time: number) => {
  if (player && player.loaded) {
    player.stop()
    player.start('+0', time)
    currentTime.value = time
  }
}

// 音量控制
const setVolume = (value: number) => {
  volume.value = value
  if (volumeNode) {
    volumeNode.volume.value = 20 * Math.log10(value) // 转换为分贝
  }
}

// 播放速度控制
const setPlaybackRate = (rate: number) => {
  playbackRate.value = rate
  if (player) {
    player.playbackRate = rate
  }
}

// 格式化时间显示
const formatTime = (seconds: number): string => {
  const mins = Math.floor(seconds / 60)
  const secs = Math.floor(seconds % 60)
  return `${mins}:${secs < 10 ? '0' : ''}${secs}`
}

// 清理资源
onUnmounted(() => {
  if (intervalId) {
    clearInterval(intervalId)
  }
  if (player) {
    player.dispose()
  }
  if (volumeNode) {
    volumeNode.dispose()
  }
})

// 暴露方法给父组件
defineExpose({
  initPlayer,
  play,
  pause,
  stop,
  seekTo,
  setVolume,
  setPlaybackRate
})
</script>

<template>
  <div class="audio-player">
    <div class="player-controls">
      <button @click="play" :disabled="isPlaying" class="control-btn">
        播放
      </button>
      <button @click="pause" :disabled="!isPlaying" class="control-btn">
        暂停
      </button>
      <button @click="stop" class="control-btn">
        停止
      </button>
    </div>

    <div class="progress-container">
      <span class="time">{{ formatTime(currentTime) }}</span>
      <input
        type="range"
        min="0"
        :max="duration"
        :value="currentTime"
        @input="(e) => seekTo(Number((e.target as HTMLInputElement).value))"
        class="progress-slider"
      />
      <span class="time">{{ formatTime(duration) }}</span>
    </div>

    <div class="volume-control">
      <label>音量:</label>
      <input
        type="range"
        min="0"
        max="1"
        step="0.01"
        :value="volume"
        @input="(e) => setVolume(Number((e.target as HTMLInputElement).value))"
        class="volume-slider"
      />
    </div>

    <div class="playback-rate">
      <label>速度:</label>
      <select
        :value="playbackRate"
        @change="(e) => setPlaybackRate(Number((e.target as HTMLSelectElement).value))"
        class="rate-select"
      >
        <option value="0.5">0.5x</option>
        <option value="0.75">0.75x</option>
        <option value="1">1x</option>
        <option value="1.25">1.25x</option>
        <option value="1.5">1.5x</option>
        <option value="2">2x</option>
      </select>
    </div>
  </div>
</template>

<style scoped lang="less">
.audio-player {
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 8px;
  background-color: #f9f9f9;
}

.player-controls {
  display: flex;
  gap: 10px;
  margin-bottom: 15px;
}

.control-btn {
  padding: 8px 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #fff;
  cursor: pointer;

  &:disabled {
    opacity: 0.5;
    cursor: not-allowed;
  }

  &:hover:not(:disabled) {
    background-color: #e6e6e6;
  }
}

.progress-container {
  display: flex;
  align-items: center;
  gap: 10px;
  margin-bottom: 15px;

  .time {
    font-size: 12px;
    color: #666;
    min-width: 40px;
  }
}

.progress-slider, .volume-slider {
  flex: 1;
  height: 6px;
  border-radius: 3px;
  background: #ddd;
  outline: none;
  -webkit-appearance: none;

  &::-webkit-slider-thumb {
    -webkit-appearance: none;
    appearance: none;
    width: 16px;
    height: 16px;
    border-radius: 50%;
    background: #409eff;
    cursor: pointer;
  }
}

.volume-control, .playback-rate {
  display: flex;
  align-items: center;
  gap: 10px;
  margin-bottom: 10px;

  label {
    font-size: 14px;
    color: #333;
  }
}

.rate-select {
  padding: 4px 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #fff;
}
</style>
