import { createApp } from 'vue'
import App from './App.vue'
//importing bootstrap
import 'bootstrap/dist/css/bootstrap.css'
//importing jquery 
import 'jquery'

//importing popper js 
import '@popperjs/core'

import router from './router'

createApp(App).use(router).mount('#app')
