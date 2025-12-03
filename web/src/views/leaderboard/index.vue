<script setup lang="ts">
import { ref } from 'vue';
import RadioGroup from '@/components/RadioGroup.vue'
import { useI18n } from 'vue-i18n'

const { t } = useI18n()

// Tab状态
const activeTab = ref('top-clicks'); // 'top-clicks' 或 'most-commented'

// 过滤器状态
const activeFilter = ref('global'); // 'global', 'by-country', 'by-language'

const options =  [
  { label: t('discover.global'), value: '1' },
  { label: t('discover.byLanguage'), value: '2' },
  { label: t('discover.byGenre'), value: '3' },
]

// 排行榜数据
const leaderboardData = [
  {
    rank: 1,
    name: 'Jazz FM London',
    country: 'UK',
    language: 'English',
    clicks: '1.2M',
    isTop: true
  },
  {
    rank: 2,
    name: 'Radio France Info',
    country: 'France',
    language: 'French',
    clicks: '980K',
    isTop: true
  },
  {
    rank: 3,
    name: 'Ibiza Global Radio',
    country: 'Spain',
    language: 'Electronic',
    clicks: '850K',
    isTop: true
  },
  {
    rank: 4,
    name: 'NPR News',
    country: 'USA',
    language: 'News',
    clicks: '720K',
    isTop: false
  }
];

// 切换Tab
const switchTab = (tab: string) => {
  activeTab.value = tab;
};

// 切换过滤器
const switchFilter = (filter: string) => {
  activeFilter.value = filter;
};
</script>

<template>
  <div class="phone-container w-full h-full bg-white overflow-hidden relative pb-16">
    <div class="p-6 pt-12 space-y-6">
      <!-- 标题 -->
      <h1 class="text-3xl font-extrabold text-black tracking-tight">Leaderboard</h1>

      <RadioGroup :options="options" v-model:value="activeFilter"></RadioGroup>

      <!-- 排行列表 -->
      <div class="space-y-2 pt-2">
        <!-- Rank items -->
        <div
          v-for="item in leaderboardData"
          :key="item.rank"
          class="flex items-center p-4"
          :class="{
            'bg-gray-50 rounded-2xl': item.isTop && item.rank === 1,
            'bg-white border-b border-gray-100': !item.isTop || item.rank > 1
          }"
        >
          <div
            class="text-center mr-4"
            :class="{
              'text-2xl font-black italic text-black w-10': item.rank === 1,
              'text-xl font-bold text-gray-400 w-10': item.rank === 2 || item.rank === 3,
              'text-lg font-medium text-gray-400 w-10': item.rank >= 4
            }"
          >{{ item.rank }}</div>

          <div
            class="mr-4 flex-shrink-0"
            :class="{
              'w-12 h-12 bg-gray-300 rounded-full': item.rank === 1 || item.rank === 2 || item.rank === 3,
              'w-10 h-10 bg-gray-100 rounded-full': item.rank >= 4
            }"
          ></div>

          <div class="flex-grow">
            <h3
              class="font-bold text-black"
              :class="{
                'text-sm': item.rank >= 4
              }"
            >{{ item.name }}</h3>
            <p
              class="text-xs text-gray-500"
              :class="{
                'text-[10px]': item.rank >= 4
              }"
            >{{ item.country }} • {{ item.language }}</p>
          </div>

          <div class="text-right">
            <div
              class="font-bold text-black"
              :class="{
                'text-sm': item.rank >= 4
              }"
            >{{ item.clicks }}</div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<style scoped>
/* 可以在这里添加额外的样式 */
</style>
