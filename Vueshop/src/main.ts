import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import mitts from 'mitt' // [mitt]
import axios from 'axios' // [axios]

import BootstrapVue3 from 'bootstrap-vue-3'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'

import { quillEditor } from 'vue3-quill'

const app = createApp(App)

// [mitt / 이벤트 버스]
const emitter = mitts()
app.config.globalProperties.$emitter = emitter

// [axios / http 통신]
app.config.globalProperties.$axios = axios

createApp(App)
  .use(store)
  .use(router)
  .use(BootstrapVue3)
  .use(quillEditor)
  .mount('#app')
