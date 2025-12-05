// global.d.ts

// 扩展 Window 接口
declare global {
  interface Window {
    process: any
  }

  interface ImportMeta {
    env: any
  }

  //  列表接口返回结果
  interface IRequestPageResponse<T> {
    records: T[],
    total: number,
  }

  type Recordable<T = any> = Record<string, T>;
}

// 如果需要使模块化文件中的全局声明生效，需要添加 export {}
export {};
