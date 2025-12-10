<script setup lang="ts">
import LeaderboardItem from './StationItem.vue'
import { useList } from '@/hooks/useList.ts'

const props = withDefaults(defineProps<{
  getData: Function
}>(), {
})

const {
  list, loading, finished, refreshing, onRefresh, onLoad,
} = useList<any>({
  apiFunc: props.getData,
})

function refresh() {
  onRefresh()
}

defineExpose({
  refresh
})

</script>

<template>
  <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
    <van-list
        v-model:loading="loading"
        :finished="finished"
        finished-text="没有更多了"
        @load="onLoad"
    >
      <div class="space-y-4">
        <LeaderboardItem
            v-for="(item, index) in list"
            :key="item.id"
            :item="item"
            :index="index"
        />
      </div>
    </van-list>
  </van-pull-refresh>
</template>

<style scoped lang="less">

</style>
