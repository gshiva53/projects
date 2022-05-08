<template>
  <div role="navigation" class="nav-container">
    <nav
      class="navbar navbar-expand-lg navbar-light"
      style="background-color: #e3f2fd"
      id="navbar"
    >
      <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
        <!-- APOD router link -->
        <li class="nav-item active">
          <router-link class="nav-link" :to="{ name: 'ApodView' }"
            >APOD</router-link
          >
        </li>

        <!-- IVL router link -->
        <li class="nav-item">
          <router-link class="nav-link" :to="{ name: 'IvlView' }"
            >IVL</router-link
          >
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
export default {};
</script>

<style>
</style>