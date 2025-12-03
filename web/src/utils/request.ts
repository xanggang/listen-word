// axios请求封装
import axios from 'axios';
import { API_URL } from '@/utils/setting'
// import type { AxiosRequestConfig, AxiosResponse, AxiosError } from 'axios';


// 创建axios实例
const request = axios.create({
  baseURL:API_URL,
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
  },
});

// // 请求拦截器
// request.interceptors.request.use(
//   (config: AxiosRequestConfig) => {
//     // 可以在这里添加认证token等
//     const token = localStorage.getItem('token');
//     if (token && config.headers) {
//       config.headers['Authorization'] = `Bearer ${token}`;
//     }
//     return config;
//   },
//   (error: AxiosError) => {
//     return Promise.reject(error);
//   }
// );
//
// // 响应拦截器
// request.interceptors.response.use(
//   (response: AxiosResponse) => {
//     // 可以根据实际业务需求调整
//     const { code, msg } = response.data;
//
//     // 如果code存在且不为0，表示业务错误
//     if (code && code !== 0) {
//       message.error(msg || '请求失败');
//       return Promise.reject(new Error(msg || '请求失败'));
//     }
//
//     return response.data;
//   },
//   (error: AxiosError) => {
//     const { response } = error;
//
//     // 统一错误提示
//     if (response) {
//       const { status, data } = response;
//       switch (status) {
//         case 400:
//           message.error(data?.message || '请求参数错误');
//           break;
//         case 401:
//           message.error('未授权，请重新登录');
//           // 可以在这里添加登出逻辑
//           break;
//         case 403:
//           message.error('拒绝访问');
//           break;
//         case 404:
//           message.error('请求资源不存在');
//           break;
//         case 500:
//           message.error('服务器内部错误');
//           break;
//         default:
//           message.error(data?.message || `连接错误 ${status}`);
//       }
//     } else {
//       message.error('网络异常，请检查网络连接');
//     }
//
//     return Promise.reject(error);
//   }
// );

export default request;

