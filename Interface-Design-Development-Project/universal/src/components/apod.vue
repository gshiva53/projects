<template>
  <div class="container-fluid">
    <!-- Row 1 -->
    <div class="row">
      <div class="col-sm-12  text-center">
        <h1>{{ apodResult.title }}</h1>
      </div>
    </div>
    <!-- Row 2 -->
    <div class="row">
      <div class="input-group input-group-sm mb-3 mt-2">
        <span class="input-group-text" id="inputGroup-sizing-sm">Date</span>
        <input type="date" class="form-control" v-model="inputDate" @input="apiFetch()" />
        <!-- Debug -->
        <!-- <p>{{ inputDate }}</p> -->
      </div>
    </div>
    <!-- Row 3 -->
    <div class="row">
      <!-- Row 3.1 -->
      <div class="row">
        <div class="col-sm-4 ">
          <!-- IF the error object does not contain an error object then show the result -->
          <div v-if="apodResult">
            <h6>{{ apodResult.date }}</h6>
            <p>{{ apodResult.explanation }}</p>
          </div>
        </div>
        <div class="col-sm-8 ">
          <div class="d-flex align-items-center">
            <div class="flex-grow-1 p-3">
              <a :href="apodResult.hdurl">
                <img :src="apodResult.url" :alt="apodResult.title" class="img-fluid p-2 rounded" />
              </a>
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
      apiKey: "tARTT0OeCAkt3TOHCOyvc6D2ZINWIbe86yOvKHa2",
      inputDate: null,
      apodResult: {},
      apodResults: [],
      error: null,
    };
  },
  methods: {
    apiFetch() {
      if (this.inputDate == null) {
        console.log(inputDate);
        this.yestardayDateAsInput();
      } else {
        fetch(
          "https://api.nasa.gov/planetary/apod?" +
          "api_key=" +
          this.apiKey +
          "&date=" +
          this.inputDate
        )
          .then((response) => response.json())
          .then((data) => (this.apodResult = data))
          .then((error) => {
            //error.error contains the error code and the error message
            this.error = error;
            console.log(error);
          });
      }
    },
    yestardayDateAsInput() {
      console.log("calling the current date method");

      //To get yestarday's date we take today's date convert it into miliseconds and
      //pass it into the date function to get yestarday's date.
      const timeStamp = new Date().getTime();
      const yestardayTimeStamp = timeStamp - 24 * 60 * 60 * 1000;

      this.inputDate = new Date(yestardayTimeStamp).toJSON().slice(0, 10);
      console.log(this.inputDate);
    },
  },
  beforeMount() {
    this.yestardayDateAsInput();
    this.apiFetch();
  },
};
</script>

<style>
</style>
