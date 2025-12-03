export enum Language {
  EN = 'en',
  ZH = 'zh'
}

export const languageOptions = [
  { text: 'English', value: Language.EN },
  { text: '简体中文', value:  Language.ZH }
]

export function getLanguageName(lan: string) {
  return languageOptions.find(item => item.value === lan)?.text
}
