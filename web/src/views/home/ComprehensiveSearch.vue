<script setup lang="ts">
import { ref } from 'vue'
import SearchInput from '@/components/SearchInput.vue'

const keyword = ref('')
</script>

<template>
<div class="search-wrap">
  <div class="search-input-wrap">
    <SearchInput v-model:keyword="keyword"></SearchInput>
  </div>

  {{ keyword }}
</div>
</template>

<style scoped lang="less">

.search-wrap {
  width: 100%;
  height: 400px;
  background-color: var(--bg-base);
  //background-color: red;

  .search-input-wrap {
    width: 100%;
    height: 3rem;
  }
}
</style>
