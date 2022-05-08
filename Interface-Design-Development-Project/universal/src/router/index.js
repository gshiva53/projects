import { createRouter, createWebHistory } from 'vue-router'
import apodView from '@/views/apod/apodView.vue'
import ivlView from '@/views/ivl/ivlView.vue'

const routes = [
  {
    path: '/',
    name: 'apodView',
    component: apodView
  },
  {
    path: '/ivl',
    name: 'ivlView',
    component: ivlView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
