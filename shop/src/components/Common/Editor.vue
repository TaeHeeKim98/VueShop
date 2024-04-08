<template>
  <quill-editor
    v-model:value="state.content"
    ref="myTextEditor"
    :options="state.editorOption"
    @change="onEditorChange($event)"
    @ready="onEditorReady($event)"
  ></quill-editor>
  <div>
    <button
      style="
        border: none;
        border-radius: 7px;
        width: 100px;
        height: 35px;
        font-size: 23px;
        margin-top: 30px;
        background-color: rgb(209, 209, 209);
        color: #2c3e50;
      "
      @click="submit(state, title)"
    >
      올리기
    </button>
  </div>
</template>

<script>
import { reactive } from 'vue'
import Quill from 'quill'
import ImageUploader from 'quill-image-uploader'
import axios from 'axios'

Quill.register('modules/imageUploader', ImageUploader)

export default {
  name: 'App',
  setup() {
    const state = reactive({
      content: '',
      _content: '',
      editorOption: {
        placeholder: '내용을 입력해주세요...',
        modules: {
          toolbar: [
            ['bold', 'italic', 'underline', 'strike'],
            ['blockquote', 'code-block'],
            [{ header: 1 }, { header: 2 }],
            [{ list: 'ordered' }, { list: 'bullet' }],
            [{ script: 'sub' }, { script: 'super' }],
            [{ indent: '-1' }, { indent: '+1' }],
            [{ direction: 'rtl' }],
            [{ size: ['small', false, 'large', 'huge'] }],
            [{ header: [1, 2, 3, 4, 5, 6, false] }],
            [{ color: [] }, { background: [] }],
            [{ font: [] }],
            [{ align: [] }],
            ['clean'],
            ['link', 'image', 'video']
          ]
        }
        // more options
      },
      disabled: false
    })

    const onEditorBlur = (quill) => {
      console.log('editor blur!', quill)
    }
    const onEditorFocus = (quill) => {
      console.log('editor focus!', quill)
    }
    const onEditorReady = (quill) => {
      quill.getModule('toolbar').addHandler('image', this.imageHandler)
      console.log('editor ready!', quill)
    }
    const onEditorChange = ({ quill, html, text }) => {
      console.log('editor change!', quill, html, text)
      state._content = html
    }

    setTimeout(() => {
      state.disabled = true
    }, 2000)

    return { state, onEditorBlur, onEditorFocus, onEditorReady, onEditorChange }
  },
  props: { no: Number, title: String, contents: String },
  data() {
    return {}
  },
  methods: {
    submit(state, title) {
      console.log(state._content)
      console.log(title)
    },
    imageHandler() {
      console.log('imageHandler start=============')

      // 1. 이미지를 저장할 input type=file DOM을 만든다.
      const input = document.createElement('input')
      // 속성 써주기
      input.setAttribute('type', 'file')
      input.setAttribute('accept', 'image/*')
      input.click() // 에디터 이미지버튼을 클릭하면 이 input이 클릭된다.
      // input이 클릭되면 파일 선택창이 나타난다.

      // input에 변화가 생긴다면 = 이미지를 선택
      input.addEventListener('change', async () => {
        const file = input.files[0]
        console.log('file :', file)

        try {
          // 파일 업로드 api 호출
          const imgUrl = 'returnData'

          // 현재 에디터 커서 위치 조회
          const range = this.editor.getSelection()

          // 커서 위치에 이미지 삽입
          this.editor.insertEmbed(range.index, 'image', imgUrl)
        } catch (error) {
          console.log('error')
        }
      })
    },
    computed: {
      editor() {
        return this.$refs.myTextEditor.quill
      }
    }
  }
}
</script>
<style>
.ql-toolbar {
  width: 800px !important;
}
.ql-container {
  width: 800px !important;
  height: 600px;
}
.ql-editor {
  height: 500px;
  overflow: scroll;
  overflow-x: hidden;
}
</style>
