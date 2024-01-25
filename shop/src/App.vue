<template>
  <div style="width: 1200px; margin: 0 auto">
    <div>
      <div style="background-color: #393939">
        <p style="color: white; text-align: left; font-size: 2rem; margin: 0px">
          <span onclick="location.href='/'" style="cursor: pointer"
            >&nbsp;story</span
          >
        </p>
        <img
          src="@/assets/logo.png"
          alt="logo"
          style="width: 200px; margin-bottom: 10px; cursor: pointer"
          onclick="location.href='/'"
        />
      </div>
      <nav style="background-color: #d1d1d1">
        <router-link class="link" to="/"
          ><img src="@/assets/app.png" alt=""
        /></router-link>
        <router-link class="link" to="/writing"
          ><img src="@/assets/writing.png" alt=""
        /></router-link>
      </nav>
    </div>
    <div>
      <div style="display: flex; flex-direction: row">
        <div style="width: 1190px">
          <router-view />
        </div>
      </div>
    </div>
  </div>
  <widget-container-modal />
</template>

<script>
import { container } from 'jenesius-vue-modal'

export default {
  components: { WidgetContainerModal: container },
  data() {
    return {
      title: ''
    }
  },
  mounted() {},
  beforeUnmount() {},
  unmounted() {},
  methods: {}
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 15px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
  text-decoration: none;
}

nav a.router-link-exact-active {
  color: #0d6efd;
}

.link {
  margin-left: 20px;
  margin-right: 20px;
}

.link > img {
  width: 30px;
}
</style>
