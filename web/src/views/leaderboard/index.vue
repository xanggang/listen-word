<script setup lang="ts">
import { onMounted, ref, watch, watchEffect } from 'vue';
import RadioGroup from '@/components/RadioGroup.vue'
import { useI18n } from 'vue-i18n'
import SlideRadioGroup from '@/components/SlideRadioGroup.vue'
import { FilterEnums, getStationPage, getTags, getLanguages } from '@/api'
import { useList } from '@/hooks/useList.ts'
import LeaderboardItem from './LeaderboardItem.vue'
import StationSList from '@/components/StationSList/index.vue'

const { t } = useI18n()

// 过滤器状态
const typeOptions = [
  { label: t('discover.global'), value: FilterEnums.ALL },
  { label: t('discover.byLanguage'), value: FilterEnums.By_Language },
  { label: t('discover.byGenre'), value: FilterEnums.By_Genre },
]
const typeActive = ref(FilterEnums.ALL); // 'global', 'by-country', 'by-language'

const tagActive = ref('')
const tagOptions = ref<{ label: string, value: string }[]>([])

const languagesOptions = ref<any[]>([])
const languageActive = ref('')

onMounted(() => {
  getTags({
    page: 1,
    pageSize: 20
  })
      .then(res => {
        tagOptions.value = res.records.map(item => ({
          label: item.name,
          value: item.id
        }))
        tagOptions.value.unshift({
          label: t('discover.global'),
          value: ''
        })
      })

  getLanguages({
    page: 1,
    pageSize: 30
  })
      .then(res => {
        languagesOptions.value = res.map(item => ({
          label: item.name,
          value: item.id,
          iso_639: item.iso_639
        }))
            .slice(0, 30)
        languagesOptions.value.unshift({
          label: t('discover.global'),
          value: ''
        })
      })
})

async function getData(data: any) {
  const par = {
    ...data,
  }

  if (typeActive.value === FilterEnums.By_Genre) {
    par.tagId = tagActive.value
  }
  if (typeActive.value === FilterEnums.By_Language) {
    par.languageId = languageActive.value
  }

  const res = await getStationPage(par)

  res.records.forEach((item, index) => {
    item.rank = (data.page - 1) * data.pageSize + index + 1
  })

  return res
}

const stationSList = ref()

watch([typeActive, tagActive, languageActive], () => {
  stationSList.value?.refresh()
})

</script>

<template>
  <div class="phone-container">
    <div class="p-6 mt-12 space-y-6 shrink-0" >
      <!-- 标题 -->
      <h1 class="text-3xl font-extrabold text-black tracking-tight">Leaderboard</h1>

      <!-- 分段控制 Tabs -->
      <SlideRadioGroup :options="typeOptions" v-model:modelValue="typeActive"></SlideRadioGroup>

      <RadioGroup v-if="typeActive === FilterEnums.By_Genre" :options="tagOptions"
                  v-model:value="tagActive"></RadioGroup>
      <RadioGroup v-if="typeActive === FilterEnums.By_Language" :options="languagesOptions"
                  v-model:value="languageActive"></RadioGroup>
    </div>

    <div class="list-wrap">
      <StationSList :get-data="getData" ref="stationSList"></StationSList>
    </div>
  </div>
</template>

<style scoped lang="less">

.phone-container {
  @apply w-full h-full bg-white overflow-hidden relative flex! flex-col;
}

.phone-container .list-wrap {
  height: 100%;
  @apply space-y-2 pt-2;
  //height: calc(50vh);
  overflow: auto;
  padding-left: 1.5rem;
  padding-right: 1.5rem;
}

.task-card {
  display: flex;
@apply items-center pt-4 ! pb-4;
  //margin-bottom: 0.2rem;
}
</style>
