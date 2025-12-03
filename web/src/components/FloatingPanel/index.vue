<script setup lang="ts">
import { watchEffect, useTemplateRef, unref } from 'vue'

const isOpen = defineModel('open', {
  type: Boolean,
  default: false
})

const panelDom = useTemplateRef('panelDom')

const maxHeight = window.innerHeight
const minHeight = 0

let isDragging = false
let startY = 0
let startTranslateY = maxHeight
let translateY = maxHeight

// 修复：使用响应式变量而不是直接修改DOM
watchEffect(() => {
  if (isOpen.value === true) {
    onOpenPanel()
  }
})

function movePanel(isAuto: boolean) {
  const panel = unref(panelDom) as HTMLElement
  if (isAuto) {
    panel.style.transition = 'all 0.3s'
    // 添加过渡结束后清除transition的处理
    setTimeout(() => {
      if (panel) panel.style.transition = ''
    }, 300)
  } else {
    panel.style.transition = 'none'
  }
  panel.style.transform = `translate3d(0, ${translateY}px, 0)`
}

function onOpenPanel() {
  isOpen.value = true
  translateY = minHeight
  movePanel(true)
}

function onClosePanel() {
  isOpen.value = false
  translateY = maxHeight
  movePanel(true)
}

// 修复：修正位置计算逻辑
function calcPos() {
  debugger
  const move = startTranslateY - translateY
  if (move > 0) {
    // 向上拖拽
    if (Math.abs(move) > maxHeight / 5) {
      onOpenPanel()
      return
    }
  } else {
    // 向下拖拽
    if (Math.abs(move) > maxHeight / 5) {
      onClosePanel()
      return
    }
  }

  // 根据当前位置决定展开还是折叠
  if (translateY > window.innerHeight / 2) {
    onClosePanel()
  } else {
    onOpenPanel()
  }
}

// 触摸事件处理（移动端支持）
const onTouchStart = (e: TouchEvent) => {
  isDragging = true
  startY = e.touches[0]?.clientY || 0
  startTranslateY = translateY
  document.addEventListener('touchmove', onTouchMove, { passive: false })
  document.addEventListener('touchend', onTouchEnd)
}

// 触摸移动处理
const onTouchMove = (e: TouchEvent) => {
  if (!isDragging) return
  e.preventDefault()
  const deltaY = (e.touches[0]?.clientY || 0) - startY
  translateY = startTranslateY + deltaY
  movePanel(false)
}

// 触摸结束处理
const onTouchEnd = () => {
  isDragging = false
  document.removeEventListener('touchmove', onTouchMove)
  document.removeEventListener('touchend', onTouchEnd)
  calcPos()
}

// 鼠标事件处理
const onmousedown = (e: MouseEvent) => {
  isDragging = true
  startY = e.clientY
  startTranslateY = translateY
  document.addEventListener('mousemove', onMouseMove)
  document.addEventListener('mouseup', onMouseUp)
}

// 鼠标移动处理
const onMouseMove = (e: MouseEvent) => {
  if (!isDragging) return
  const deltaY = e.clientY - startY
  translateY = startTranslateY + deltaY
  movePanel(false) // 修复：鼠标拖动时也不需要动画
}

// 鼠标释放处理
const onMouseUp = () => {
  console.log(111)
  isDragging = false
  document.removeEventListener('mousemove', onMouseMove)
  document.removeEventListener('mouseup', onMouseUp)
  calcPos()
}
</script>

<template>
  <div
    class="float-panel-container"
    ref="panelDom"
  >
    <div
      class="panel-header"
      @mousedown="onmousedown"
      @touchstart="onTouchStart"
    >
      <div class="drag-indicator"></div>
      头部点击区域 {{ translateY }} {{ isOpen }}
    </div>

    <div class="panel-center">
      <div class="content-wrapper">
        <slot></slot>
      </div>
    </div>
  </div>
</template>


<style scoped lang="less">

.float-panel-container {
  width: 100%;
  height: 120px;
  position: absolute;
  left: 0;
  top: 0;
  transform: translate3d(0, 100vh, 0);
  //transition: all 0.5s;

  .panel-header {
    width: 100%;
    height: 4rem;
    background-color: #fff;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: var(--text-size-2xl);
    color: var(--text-base);
    box-sizing: border-box;
    padding: 20px 0;
    cursor: move;
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    position: relative;

    &:after {
      display: block;
      content: '';
      width: 3rem;
      height: 4px;
      border-radius: 2px;
      background-color: var(--oc-gray-7);
      left: 50%;
      margin-left: -15px;
      position: absolute;
      top: 0.3rem;
    }
  }

  .panel-center {
    width: 100%;
    height: calc(100vh - 4rem - calc(var(--gap) * 2 + var(--controller-height)) - 1rem);
    box-sizing: border-box;
    overflow-y: auto;

    .content-wrapper {
      width: 100%;
      padding: var(--gap);
      box-sizing: border-box;
    }
  }
}
</style>
