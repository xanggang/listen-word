import { ref, onMounted } from 'vue'

interface UseListOptions<T> {
  /** 请求API函数 (必须返回Promise) */
  apiFunc: (
    params: any,
  ) => Promise<IRequestPageResponse<T>>
  /** 是否立即请求（默认true） */
  immediate?: boolean
  /** 每页条数（默认10） */
  pageSize?: number
  /** 其他固定查询参数 */
  params?: Record<string, any>
}

export function useList<T>(options: UseListOptions<T>) {
  const {
    apiFunc,
    immediate = false,
    pageSize = 10,
    params = {},
  } = options

  const searchParams = ref<Recordable>({})
  searchParams.value = { ...params }
  // 列表数据
  const list = ref<T[]>([])
  // 加载状态
  const loading = ref(false)
  // 刷新状态
  const refreshing = ref(false)
  // 是否加载完成
  const finished = ref(false)
  // 当前页码
  const page = ref(1)
  // 总条数
  const total = ref(0)

  // 加载数据
  const loadData = async (action: 'refresh' | 'load') => {
    try {
      if (action === 'refresh') {
        page.value = 1
        refreshing.value = true
      } else {
        loading.value = true
      }

      const response = await apiFunc({
        page: page.value,
        pageSize,
        ...searchParams.value,
      })
      const { total: resTotal = 0 } = response
      const rows = response.records || []
      if (action === 'refresh') {
        list.value = rows
      } else {
        list.value = [...(list.value as T[]), ...rows]
      }

      total.value = resTotal
      finished.value = rows.length < pageSize || list.value.length >= resTotal

      if (action === 'refresh') {
        refreshing.value = false
      } else {
        loading.value = false
      }
      page.value++
    } catch (error) {
      list.value = []
      console.error('List load error:', error)
      finished.value = true
      loading.value = false
      throw error
    }
  }

  // 下拉刷新
  const onRefresh = (pa: Recordable = {}) => {
    searchParams.value = { ...searchParams.value, ...pa }
    return loadData('refresh')
  }

  // 上拉加载
  const onLoad = (pa: Recordable = {}) => {
    searchParams.value = { ...searchParams.value, ...pa }
    return loadData('load')
  }

  // 首次加载
  onMounted(() => {
    if (immediate) {
      loadData('refresh')
    }
  })

  return {
    /** 列表数据 */
    list,
    /** 加载状态 */
    loading,
    /** 完成状态 */
    finished,
    /** 刷新状态 */
    refreshing,
    /** 当前页码 */
    page,
    /** 总条数 */
    total,
    /** 手动刷新 */
    onRefresh,
    /** 加载更多 */
    onLoad,
  }
}
