<template>
  <div id="black-bg">
    <div id="white-bg" style="overflow-y: scroll">
      <p
        @click.self="close"
        style="
          display: flex;
          justify-content: flex-end;
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
        <div style="display: flex; width: 800px; font-size: 1.3rem" :v-html="contents">
          {{ contents }}
        </div>
      </div>
      <div style="display: flex; justify-content: space-between">
        <button
          style="
            background-color: rgb(100, 201, 100);
            font-weight: bold;
            color: white;
          "
          @click="writing(no, title, contents)"
        >
          수정
        </button>
        <button
          style="
            background-color: rgb(253, 86, 95);
            font-weight: bold;
            color: white;
          "
          @click="deleteItem(no)"
        >
          삭제
        </button>
      </div>
    </div>
  </div>
</template>
<script>
import { closeModal } from 'jenesius-vue-modal'
import axios from 'axios'
import router from '@/router'
axios.defaults.baseURL = 'http://localhost'

export default {
  components: {},
  props: { no: Number, title: String, contents: String, regDate: String },
  // data() {},
  // setup() {},
  // created() {},
  // mounted() {},
  // unmounted() {},
  methods: {
    close() {
      closeModal(this)
    },
    async deleteItem(no) {
      console.log(no)
      await axios
        .delete('/deletItem?no=' + no)
        .then((res) => {
          if (String(res.data) === 'true') {
            console.log('성공!')
            router.go(0)
          } else {
            alert('게시물 삭제에 실패했습니다.')
            router.go(0)
          }
        })
        .catch(() => {
          console.log('err!!!')
        })
    },
    writing(no, title, contents) {
      console.log(no, title, contents)
      router.push({
        name: 'Rewriting',
        params: { no: no, _title: title, constents: contents }
      })
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
#white-bg > div > button {
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
