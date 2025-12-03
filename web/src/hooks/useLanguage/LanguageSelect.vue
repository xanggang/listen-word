<script setup lang="ts">
import { languageOptions } from './hooks.ts'
import type { PickerChangeEventParams } from 'vant'

import { useI18n } from 'vue-i18n'
import { LANGUAGE, localSet } from '@/utils/cache.ts'

const { locale } = useI18n()


// const pickerValue = defineModel('value', { type: String, default: '' })
const showPicker = defineModel('show', { type: Boolean, default: false })

function onConfirm({ selectedValues }: PickerChangeEventParams) {
  showPicker.value = false
  const lang = selectedValues[0] as string
  localSet(LANGUAGE, lang)
  locale.value = lang
}
</script>

<template>
  <van-popup v-model:show="showPicker" destroy-on-close round position="bottom">
    <van-picker
      :columns="languageOptions"
      @cancel="showPicker = false"
      @confirm="onConfirm"
    />
  </van-popup>
</template>

<style scoped lang="less">

</style>
