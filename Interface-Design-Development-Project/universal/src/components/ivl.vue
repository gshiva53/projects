// IVL -> NASA Image and Video Library API
<template>
  <div class="container">
    <!-- Row 1 -->
    <div class="row">
      <div class="col-sm-12 ">
        <div class="input-group input-group-sm mb-3 mt-2">
          <label class="input-group-text" id="inputGroup-sizing-sm">Search</label>
          <!-- When the search input changes then call the apiFetch() function -->
          <input type="text" class="form-control" v-model.lazy="search" @change="apiFetch()" />
          <!-- If the search is not null then render spinners -->
          <div v-if="!search" class="d-flex align-items-center">
            <button class="btn btn-light" type="button" disabled>
              <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
              <span class="visually-hidden">Loading...</span>
            </button>
          </div>
        </div>
      </div>
    </div>
    <!-- Row 2 -->
    <!-- This div element will only exist if the data is NOT null, that is, if data is received while fetching the API -->
    <div v-if="data">
      <!-- We can either take the length of the items array OR take the number of hits from metadata -->
      <div v-if="data.collection.metadata.total_hits > 0">
        <div v-for="(item, index) in data.collection.items" :key="index">
          <div class="row">
            <div class="row-cols-1 g-3">
              <!-- Card 1 -->
              <div class="card">
                <img :src="item.links[0].href" class="card-img-top" alt="item.data[0].title" />
                <div class="card-body">
                  <h5 class="card-title">{{ item.data[0].title }}</h5>
                  <p class="card-text">{{ item.data[0].description }}</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      search: null,
      data: null,
      media_type: "image",
      page: "1",
    };
  },
  methods: {
    apiFetch() {
      fetch(
        "https://images-api.nasa.gov" +
        "/search?q=" +
        this.search +
        "&media_type=" +
        this.media_type +
        "&page=" +
        this.page
      )
        .then((response) => response.json())
        .then((data) => (this.data = data))
        .then((error) => console.log(error));
    },
  },
};
</script>

<style>
</style>
