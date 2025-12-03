// global.d.ts

// 扩展 Window 接口
declare global {
  interface Window {
    process: any
  }

  interface ImportMeta {
    env: any
  }
}

// 如果需要使模块化文件中的全局声明生效，需要添加 export {}
export {};
