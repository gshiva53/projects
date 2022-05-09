<template>
  <!-- Footer -->
  <footer class="text-center text-dark">
    <!-- Grid container -->
    <div class="container p-4">
      <!-- Section: Social media -->
      <section class="mb-4">
        <!-- Linkedin -->
        <a class="btn btn-outline-dark btn-floating m-1" href="https://github.com/gshiva53" role="button"
          ><img
            src="@\assets\Footer-icons\GitHub-icon.png"
            alt="GitHub icon"
            width="30"
            height="30"
        /></a>

        <!-- Github -->
        <a class="btn btn-outline-dark btn-floating m-1" href="https://www.linkedin.com/in/shiva-gupta-003613218?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_view_base_contact_details%3Bp6RdyJ66Rkarw3ijmDib8Q%3D%3D" role="button"
          ><img
            src="@\assets\Footer-icons\linkedin-icon.png"
            alt="Linkedin icon"
            width="30"
            height="30"
          /></a
        >
      </section>
      <!-- Section: Social media -->

      <!-- Section: Form -->
      <section class="">
        <form action="">
          <!--Grid row-->
          <div class="row d-flex justify-content-center">
            <!--Grid column-->
            <div class="col-auto">
              <p class="pt-2">
                <strong>Sign up for our newsletter</strong>
              </p>
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-md-5 col-12">
              <!-- Email input -->
              <div class="form-outline form-black mb-4">
                <input type="email" id="form5Example21" class="form-control" />
                <label class="form-label" for="form5Example21"
                  >Email address</label
                >
              </div>
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-auto">
              <!-- Submit button -->
              <button type="submit" class="btn btn-outline-dark mb-4">
                Subscribe
              </button>
            </div>
            <!--Grid column-->
          </div>
          <!--Grid row-->
        </form>
      </section>
      <!-- Section: Form -->

      <!-- Section: Text -->
      <section class="mb-4">
        <p>
          This website was developed for the purpose of learning. It explores
          how breathtaking our space really is and how organizations like NASA,
          ISRO can spread more awareness just by exposing the content, be that
          in the form of APIs. For more information about NASA APIs:
          https://api.nasa.gov
        </p>
      </section>
      <!-- Section: Text -->

      <!-- Section: Links -->
      <section class="">
        <!--Grid row-->
        <div class="row">
          <!--Grid column-->
          <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
            <ul class="list-unstyled mb-0">
              <li>
                <router-link class="nav-link" :to="{ name: 'ApodView' }"
                  >APOD</router-link
                >
              </li>
            </ul>
          </div>
          <!--Grid column-->

          <!--Grid column-->
          <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
            <ul class="list-unstyled mb-0">
              <li>
                <router-link class="nav-link" :to="{ name: 'IvlView' }"
                  >IVL</router-link
                >
              </li>
            </ul>
          </div>
          <!--Grid column-->

          <!--Grid column-->
          <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
            <ul class="list-unstyled mb-0">
              <li>
                <router-link class="nav-link" :to="{ name: 'IvlView' }"
                  >IVL</router-link
                >
              </li>
            </ul>
          </div>

          <!--Grid column-->
          <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
            <ul class="list-unstyled mb-0">
              <li>
                <router-link class="nav-link" :to="{ name: 'ApodView' }"
                  >APOD</router-link
                >
              </li>
            </ul>
          </div>
          <!--Grid column-->
        </div>
        <!--Grid row-->
      </section>
      <!-- Section: Links -->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">
      © 2020 Copyright:
      <a class="text-black" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
  </footer>
  <!-- Footer -->
</template>

<script>
export default {};
</script>

<style>
footer {
  background-color: #e3f2fd;
}
</style>