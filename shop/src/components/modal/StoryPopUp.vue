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
        <div style="width: 800px; height: 950px; font-size: 1.3rem; overflow:scroll;">
          {{ contents }}
        </div>
      </div>
      <div style="display: flex; justify-content: space-between;">
        <button style="background-color: rgb(100, 201, 100);; font-weight: bold; color: white; ">수정</button>
        <button style="background-color: rgb(253, 86, 95); font-weight: bold; color: white; ">삭제</button>
      </div>
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
#white-bg >div> button {
  border: none;
  padding: 10px;
  width: 80px;
  background-color: rgb(236, 236, 236);
  border-radius: 5px;
  display: flex;
  align-items: center;
  justify-content: center;
  float: right;
  margin-top: 30px;
  margin-left: 80px;
  margin-right: 80px;
}
#title {
  margin-top: 50px;
}
</style>
