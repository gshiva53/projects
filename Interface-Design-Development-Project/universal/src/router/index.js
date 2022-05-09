import { createRouter, createWebHistory } from 'vue-router'
import ApodView from '@/views/apod/ApodView.vue'
import IvlView from '@/views/ivl/IvlView.vue'
import AboutView from '@/views/AboutView.vue'

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
  }, 
  {
    path: '/about',
    name: 'AboutView',
    component: AboutView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
