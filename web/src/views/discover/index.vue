<script setup lang="ts">
import { ref, watch } from 'vue';
import BottomNavBar from '@/components/BottomNavBar.vue';
import SearchInput from '@/components/SearchInput.vue'
import { useI18n } from 'vue-i18n'
import { showToast } from 'vant'
import { getStationPageByKeyWord, type Station } from '@/api'
import LeaderboardItem from '@/views/leaderboard/LeaderboardItem.vue'
import { debounce } from 'lodash-es';

const { t } = useI18n()

// 搜索关键词
const keyword = ref('');

// 推荐电台数据
const trendingStations = ref<Station[]>([])



// 模糊搜索
const debouncedSearch = debounce(async (keyword: string) => {
  const res = await getStationPageByKeyWord({
    keyword,
    page: 1,
    pageSize: 20
  });
  trendingStations.value = res.records;
}, 300);

watch(keyword, debouncedSearch)
</script>

<template>
  <div class="phone-container w-full h-full bg-white overflow-hidden relative">
    <div class="p-6 pt-12 space-y-8 h-full">
      <!-- 标题 & 搜索框 -->
       <SearchInput  v-model:keyword="keyword" :placeholder="t('discover.placeholder')" />

      <!-- 推荐结果列表 -->
      <div class="space-y-4 h-[calc(100%-5rem)]">
        <h2 class="text-lg font-bold text-black">Trending Worldwide</h2>
        <div class="space-y-4 overflow-y-auto h-[calc(100%-1rem)]">

          <LeaderboardItem
              :item="station"
              v-for="station in trendingStations"
              :key="station.id">
          </LeaderboardItem>
        </div>
      </div>

    </div>

    <!-- 底部导航栏 -->
    <BottomNavBar />
  </div>
</template>

<style lang="less" scoped>

.phone-container {

}
</style>
