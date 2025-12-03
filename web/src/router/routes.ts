import type { RouteRecordRaw } from 'vue-router'

const routes: RouteRecordRaw[] = [
  {
    path: '/test',
    name: 'Test',
    component: () => import('@/views/test/index.vue')
  },
  {
    path: '/home',
    name: 'Home',
    component: () => import('@/views/home/index.vue')
  },
  // 新增的播放器页面路由
  {
    path: '/player',
    name: 'Player',
    component: () => import('@/views/player/index.vue')
  },
  // 新增的发现页面路由
  {
    path: '/discover',
    name: 'Discover',
    component: () => import('@/views/discover/index.vue')
  },
  // 新增的排行榜页面路由
  {
    path: '/leaderboard',
    name: 'Leaderboard',
    component: () => import('@/views/leaderboard/index.vue')
  },
  // 新增的设置页面路由
  {
    path: '/settings',
    name: 'Settings',
    component: () => import('@/views/settings/index.vue')
  },
  // 重定向到播放器页面作为默认路由
  {
    path: '/',
    redirect: '/player'
  }
]

export default routes

