import { createRouter, createWebHistory } from 'vue-router'
import ApodView from '@/views/apod/ApodView.vue'
import IvlView from '@/views/ivl/IvlView.vue'

const routes = [
  {
    path: '/',
    name: 'ApodView',
    component: ApodView
  },
  {
    path: '/ivl',
    name: 'IvlView',
    component: IvlView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
