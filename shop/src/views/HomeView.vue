<template>
  <div class="home" style="width: 1200px">
    <div>
      <div style="margin-top: 20px">
        <div class="row row-cols-1 row-cols-md-3 g-4">
          <div class="col" v-for="(item,index) in data" :key="index">
            <div class="card" @click="openpopup(item.no, item.title, item.contents, item.regDate)">
              <img src="@/assets/noimage.gif" class="card-img-top" alt="..." />
              <div class="card-body">
                <h5 class="card-title">{{item.title}}</h5>
                <p class="card-text">{{item.contents}}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <br />
  <br />
</template>

<script lang="ts">
import storyPopUp from '@/components/modal/StoryPopUp.vue'
import { openModal } from 'jenesius-vue-modal'
import axios from 'axios'
axios.defaults.baseURL = 'http://localhost'

export default {
  data() {
    return {
      data: ''
    }
  },
  created() {
    axios
      .get('/home', {})
      .then((res) => {
        console.log('data : ' + JSON.stringify(res.data))
        this.data = res.data.homelist
      })
      .catch((res) => {
        console.log('err : ' + res)
      })
  },
  mounted() {},
  methods: {
    async openpopup(no: Number, title: String, contents: String, regDate: String) {
      const modal = await openModal(storyPopUp, {
        no: no,
        title: title,
        contents: contents,
        regDate: regDate
      })

      modal.onclose = () => {}
    }
    // async getStoryList() {
    //   await axios
    //     .get('/', {})
    //     .then((res) => {
    //       console.log('data : ' + res.data)
    //       this.data = res.data
    //     })
    //     .catch((res) => {
    //       console.log(res)
    //     })
    // }
  }
}
</script>
<style>
.card-title{
  font-size: 30px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.card-text {
  height: 70px;
  overflow: hidden;
}
.col.card {
  z-index: 2;
}
.card-body {
  height: 160px;
  overflow: hidden;
}
.card {
  cursor: pointer;
}
</style>
