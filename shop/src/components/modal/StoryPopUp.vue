<template>
  <div id="black-bg">
    <div id="white-bg" style="overflow-y: scroll">
      <p
        @click.self="close"
        style="
          position: fixed;
          top: 30px;
          right: 190px;
          z-index: 3;
          font-size: 20px;
          cursor: pointer;
        "
      >
        X
      </p>
      <h2 id="title">{{ title }}</h2>
      <p style="text-align: right; margin-right: 10vw; font-size: 1.3rem">
        {{ regDate }}
      </p>
      <div style="display: flex; justify-content: center">
        <div style="width: 800px; font-size: 1.3rem">
          {{ contents }}
        </div>
      </div>
      <button>삭제</button>
    </div>
  </div>
</template>
<script>
import { closeModal } from 'jenesius-vue-modal'

export default {
  components: {},
  props: { no: Number, title: String, contents: String, regDate: String },
  data() {},
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {
    close() {
      closeModal(this)
    }
  }
}
</script>
<style>
body {
  margin: 0;
}
::-webkit-scrollbar {
  display: none;
}
div {
  box-sizing: border-box;
}
#black-bg {
  z-index: 2;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  position: fixed;
  padding: 20px;
  display: flex;
  justify-content: center;
}
#white-bg {
  width: 80%;
  height: 100%;
  background-color: white;
  border-radius: 8px;
  padding: 20px;
}
#white-bg > button {
  border: none;
  padding: 10px;
  width: 80px;
  background-color: rgb(236, 236, 236);
  border-radius: 5px;
  display: flex;
  align-items: center;
  justify-content: center;
  float: right;
  margin-right: 50px;
}
#title {
  margin-top: 50px;
}
</style>
