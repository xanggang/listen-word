<script setup lang="ts">
import { ref } from 'vue';
import { LanguageSelect } from '@/hooks/useLanguage'
import { useI18n } from 'vue-i18n'
import { getLanguageName } from '@/hooks/useLanguage/hooks.ts'

const { t, locale } = useI18n()


const isShow = ref(false)

// 切换开关状态
const nightMode = ref(false);
const autoCenterOnPlay = ref(true);

// 切换夜间模式
const toggleNightMode = () => {
  nightMode.value = !nightMode.value;
};

// 切换自动居中
const toggleAutoCenter = () => {
  autoCenterOnPlay.value = !autoCenterOnPlay.value;
};

// 处理语言选择
const handleLanguageClick = () => {
  isShow.value = true
  console.log('Language settings clicked');
  // 这里可以添加语言设置的逻辑
};

// 处理清除缓存
const handleClearCacheClick = () => {
  console.log('Clear cache clicked');
  // 这里可以添加清除缓存的逻辑
};

// 处理关于页面
const handleAboutClick = () => {
  console.log('About clicked');
  // 这里可以添加关于页面的逻辑
};
</script>

<template>
  <div class="phone-container w-full h-full bg-white overflow-hidden relative pb-16">
    <div class="p-6 pt-12 space-y-8">
      <!-- 标题 -->
      <h1 class="text-3xl font-extrabold text-black tracking-tight">
        {{ t('settings.setting')}}
      </h1>

      <!-- 设置列表群组 -->
      <div class="space-y-6">
        <!-- Group 1: Preferences -->
        <div>
          <h2 class="text-sm font-bold text-gray-500 uppercase tracking-wider mb-3 px-2">
            {{ t('settings.preferences')}}
          </h2>
          <div class="bg-gray-50 rounded-2xl overflow-hidden">
            <!-- Language Item -->
            <div class="flex items-center justify-between p-5 border-b border-gray-200 cursor-pointer active:bg-gray-100" @click="handleLanguageClick">
              <span class="text-lg font-medium text-black">
                   {{ t('settings.language')}}
              </span>
              <div class="flex items-center text-gray-500">
                <span class="mr-3">
                  {{ getLanguageName(locale) }}
                </span>
                <!-- Chevron Right Icon -->
                <div class="w-2 h-2 border-t-2 border-r-2 border-gray-400 transform rotate-45"></div>
              </div>
            </div>
            <!-- Night Mode Item -->
            <div class="flex items-center justify-between p-5">
              <span class="text-lg font-medium text-black">
                 {{ t('settings.nightMode')}}
              </span>
              <!-- Toggle Switch -->
              <div class="toggle-bg cursor-pointer" :class="{ 'on': nightMode }" @click="toggleNightMode">
                <div class="toggle-dot shadow-sm"></div>
              </div>
            </div>
          </div>
        </div>

        <!-- Group 2: Map Settings -->
        <div v-if="false">
          <h2 class="text-sm font-bold text-gray-500 uppercase tracking-wider mb-3 px-2">Map Options</h2>
          <div class="bg-gray-50 rounded-2xl overflow-hidden">
            <div class="flex items-center justify-between p-5 border-b border-gray-200">
              <span class="text-lg font-medium text-black">Auto-Center on Play</span>
              <!-- Toggle Switch (ON state) -->
              <div class="toggle-bg cursor-pointer" :class="{ 'on': autoCenterOnPlay }" @click="toggleAutoCenter">
                <div class="toggle-dot shadow-sm"></div>
              </div>
            </div>
            <div class="flex items-center justify-between p-5 cursor-pointer active:bg-gray-100" @click="handleClearCacheClick">
              <span class="text-lg font-medium text-black">Clear Map Cache</span>
              <!-- Chevron Right Icon -->
              <div class="w-2 h-2 border-t-2 border-r-2 border-gray-400 transform rotate-45"></div>
            </div>
          </div>
        </div>

        <!-- Group 3: About -->
        <div>
          <div class="bg-white border border-gray-100 rounded-2xl overflow-hidden mt-8">
            <div class="flex items-center justify-center p-5 cursor-pointer active:bg-gray-50 text-black font-medium" @click="handleAboutClick">
              About GeoRadio v1.0
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <LanguageSelect v-model:show="isShow"></LanguageSelect>
</template>

<style scoped>
/* 模拟 Toggle 开关 */
.toggle-bg {
  width: 48px; height: 24px; background-color: #d1d5db; border-radius: 12px; position: relative;
}

.toggle-bg.on { background-color: black; }

.toggle-dot {
  width: 20px; height: 20px; background-color: white; border-radius: 50%; position: absolute; top: 2px; left: 2px; transition: all 0.2s;
}

.toggle-bg.on .toggle-dot { left: 26px; }
</style>
