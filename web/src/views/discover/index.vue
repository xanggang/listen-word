<script setup lang="ts">
import { ref } from 'vue';
import BottomNavBar from '@/components/BottomNavBar.vue';
import SearchInput from '@/components/SearchInput.vue'
import { useI18n } from 'vue-i18n'

const { t } = useI18n()

// 搜索关键词
const searchQuery = ref('');

// 分类数据
const categories = [
  { id: 2, name: t('discover.byLanguage'), isActive: false },
  { id: 3, name: t('discover.byGenre'), isActive: false },
];

// 推荐电台数据
const trendingStations = [
  {
    id: 1,
    name: 'BBC Radio 1',
    location: 'London, UK',
    genre: 'Pop'
  },
  {
    id: 2,
    name: 'KEXP 90.3 FM',
    location: 'Seattle, USA',
    genre: 'Alternative'
  }
];

</script>

<template>
  <div class="phone-container w-full h-full bg-white overflow-hidden relative">
    <div class="p-6 pt-12 space-y-8">
      <!-- 标题 & 搜索框 -->
       <SearchInput v-model="searchQuery" :placeholder="t('discover.placeholder')" />

      <!-- 推荐结果列表 -->
      <div class="space-y-4">
        <h2 class="text-lg font-bold text-black">Trending Worldwide</h2>
        <div class="space-y-4">
          <!-- 卡片 -->
          <div
            v-for="station in trendingStations"
            :key="station.id"
            class="flex items-center p-3 bg-white border border-gray-100 rounded-2xl shadow-lg cursor-pointer"
          >
            <div class="w-16 h-16 bg-gray-200 rounded-xl mr-4 flex-shrink-0"></div> <!-- Placeholder for station logo -->
            <div class="flex-grow">
              <h3 class="font-bold text-black leading-6 text-xl">{{ station.name }}</h3>
              <p class="text-sm text-gray-700 leading-5 text-lg">{{ station.location }} • {{ station.genre }}</p>
            </div>
          </div>
        </div>
      </div>

    </div>

    <!-- 底部导航栏 -->
    <BottomNavBar />
  </div>
</template>

<style scoped>

</style>
