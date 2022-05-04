<template>
  <apod></apod>
  <hr>
  <ivl></ivl>
</template>

<script>
import apod from './components/apod.vue'
import ivl from './components/ivl.vue'

export default {
  components: { apod, ivl }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
