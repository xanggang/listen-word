import { createI18n,  } from 'vue-i18n'

import en from './config/en'
import zh from './config/zh'
import { LANGUAGE, localGet } from '@/utils/cache.ts'
import { getCurrentLang } from '@/hooks/useLanguage/utils.ts'



const i18n = createI18n({
  locale: localGet(LANGUAGE) || getCurrentLang(),
  fallbackLocale: 'en',
  messages: {
    en,
    zh
  }
})

export default i18n
