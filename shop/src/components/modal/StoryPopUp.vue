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
        {{ `${sampleDateYear} - ${sampleDateMonth} - ${sampleDate} ` }} 등록일
      </p>
      <div style="display: flex; justify-content: center">
        <div style="width: 800px; font-size: 1.3rem">
          Lorem ipsum dolor sit amet consectetur, adipisicing elit. Sint sit,
          delectus dicta provident, labore dolorum itaque, perferendis molestias
          soluta maiores ad quia molestiae. Nobis deleniti natus dolorem sit qui
          beatae sunt impedit, ut provident aspernatur? Voluptates explicabo
          totam neque nostrum ab sunt, minima officia porro vel maxime voluptas
          laboriosam animi, illum accusamus, pariatur repellendus tempore
          assumenda dolor veniam quia earum quidem! Sequi explicabo facilis
          itaque distinctio magni alias consequatur! Laudantium, id asperiores
          quo numquam pariatur eius ex fuga reprehenderit? Repellendus molestiae
          iure animi rem numquam asperiores autem? Consequatur natus libero
          praesentium! Nostrum fugiat alias perferendis, perspiciatis impedit ex
          facilis dolorum atque deleniti corporis, quae fuga molestias quaerat
          voluptatibus blanditiis sint optio praesentium aspernatur excepturi.
          Itaque nesciunt omnis doloribus pariatur voluptatibus repellendus sint
          perspiciatis nobis. Numquam soluta, est nesciunt laboriosam accusamus
          tenetur corporis mollitia debitis enim incidunt natus explicabo nam
          sit nemo sequi deserunt! Nemo, deleniti odio quae quis possimus, iste
          fugiat exercitationem, odit eaque perspiciatis voluptates ipsa quasi
          dolorum! Beatae mollitia, blanditiis fugit ab repellendus, sint
          officiis reiciendis quia animi quas deserunt voluptates, vitae in
          aspernatur ullam excepturi a odit! Ipsa qui placeat, inventore velit
          consequuntur quod autem maiores, adipisci ea possimus odio aliquam
          laudantium ipsam, consequatur soluta totam repellendus id accusamus
          animi. Quos praesentium impedit dolor, sint asperiores quisquam quasi
          velit recusandae cumque ipsum itaque quis eum tempora dolores amet,
          quae veritatis doloremque facere molestiae? Eius voluptas placeat
          porro? Sed placeat aliquam id voluptatum recusandae perspiciatis et
          ipsa quidem atque non voluptate maiores excepturi dicta in, itaque a
          veritatis nihil dolor laboriosam eos! Dolorum id voluptate recusandae
          nobis odit a incidunt ipias incidunt ea. Sit dolore nemo eaque totam
          corrupti doloremque architecto necessitatibus praesentium molestias,
          voluptatem quod iure assumenda illo quaerat iusto rerum. Ipsam
          deleniti, officia velvoluptas fugiat reiciendis.
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
  props: { title: String },
  data() {
    let sampleDateYear = new Date().getFullYear()
    let sampleDateMonth = new Date().getMonth()
    let sampleDate = new Date().getDate()
    if (sampleDateMonth < 10) {
      sampleDateMonth = `0${sampleDateMonth}`
    }
    if (sampleDate < 10) {
      sampleDate = `0${sampleDate}`
    }

    return {
      sampleDateYear: sampleDateYear,
      sampleDateMonth: sampleDateMonth,
      sampleDate: sampleDate
    }
  },
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
