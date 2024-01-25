<template>
  <div>
    <p style="font-size: 1.5rem; margin: 5px; margin-top: 100px; width: 430px">
      제목
    </p>
    <input
      type="text"
      v-model="title"
      style="
        width: 800px;
        height: 35px;
        border-radius: 10px;
        border: 2px solid #2c3e50;
      "
    />
    <div style="display: flex; justify-content: center; margin-top: 30px">
      <div class="editor-page">
        <editor></editor>
      </div>
    </div>
  </div>
</template>
<script>
import Editor from '@/components/Common/Editor.vue'

export default {
  components: { Editor },
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
.note-editable {
  height: 400px;
}
.note-editor {
  border-radius: 10px;
}
.editor-page {
  margin-bottom: 120px;
}
</style>
