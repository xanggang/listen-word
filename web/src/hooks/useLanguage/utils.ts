import { LANGUAGE, localGet } from '@/utils/cache.ts'

export function getCurrentLang() {
  const cache = localGet(LANGUAGE)
  if (cache) return cache
  const language = navigator.language || (navigator as any).userLanguage;
  return language.slice(0, 2)
}
