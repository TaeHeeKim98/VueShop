<template>
  <div class="home" style="width: 1200px">
    <div>
      <div style="margin-top: 20px">
        <div class="row row-cols-1 row-cols-md-3 g-4">
          <div class="col" v-for="index in 6" :key="index">
            <div class="card" @click="openpopup()">
              <img src="@/assets/noimage.gif" class="card-img-top" alt="..." />
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">This is a longer card</p>
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

export default {
  data() {
    return {
      data: ''
    }
  },
  methods: {
    async openpopup() {
      const modal = await openModal(storyPopUp, {
        title: '그룹코드 등록'
      })

      modal.onclose = () => {}
    }
  }
}
</script>
<style>
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
