/// <reference types="vite/client" />


// 对process.env扩展
interface ImportMetaEnv {
  readonly VUE_APP_API_BASE_URL: string;
  readonly VITE_API_URL: string;
}

interface ImportMeta {
  readonly env: ImportMetaEnv;
}
