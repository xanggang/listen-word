import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import type { Station } from '@/api'

export const usePlayerStore = defineStore('player', () => {

  const currentStation = ref<Partial<Station>>({})

  const handlePlayerStation = (station: Station) => {
    currentStation.value = station
  }

  return {
    currentStation,
    handlePlayerStation,
  }
})
