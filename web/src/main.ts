import { createApp } from 'vue'
import { createPinia } from 'pinia'
import i18n from '@/i18n'
import 'virtual:uno.css'
import '@/style/index.less'
import '@unocss/reset/normalize.css'
import { Picker, Popup } from 'vant';
import 'vant/lib/index.css';


import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(Picker)
app.use(Popup)

app.use(i18n)

app.mount('#app')
