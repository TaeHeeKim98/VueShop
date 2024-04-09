<template>
  <quill-editor
    v-model:value="state.content"
    :options="state.editorOption"
    @change="onEditorChange($event)"
  ></quill-editor>
  <div>
    <button
      v-if="type === 'writing'"
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
      @click="submit(no, title, state._content, this.type)"
    >
      올리기
    </button>
    <button
      v-if="type === 'rewriting'"
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
      @click="submit(no, title, state._content, this.type)"
    >
      수정
    </button>
  </div>
</template>

<script>
import { reactive } from 'vue'
import axios from 'axios'
import router from '@/router'
axios.defaults.baseURL = 'http://localhost'

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

    const onEditorBlur = (editor) => {
      console.log('editor blur!', editor)
    }
    const onEditorFocus = (editor) => {
      console.log('editor focus!', editor)
    }
    const onEditorReady = (editor) => {
      console.log('editor ready!', editor)
    }
    const onEditorChange = ({ editor, html, text }) => {
      console.log('editor change!', editor, html, text)
      state._content = html
    }

    setTimeout(() => {
      state.disabled = true
    }, 2000)

    return { state, onEditorBlur, onEditorFocus, onEditorReady, onEditorChange }
  },
  props: { no: Number, title: String, type: String },
  created() {
    console.log('editor: ', this.no + this.title + this.contents)
    axios
      .get('/getItem', {
        params: {
          no: this.no
        }
      })
      .then((res) => {
        console.log('editor/getItem : ', JSON.stringify(res.data.getItem))
        this.state.content = res.data.getItem.contents
      })
  },
  data() {
    return {}
  },
  methods: {
    submit(no, title, contents, type) {
      if (type === 'writing') {
        console.log('param : ' + title + contents)
        axios
          .post('/createItem', null, {
            params: {
              title: title,
              contents: contents
            }
          })
          .then((res) => {
            if (String(res.data) === 'true') {
              console.log('성공!' + res.data)
              alert('게시물 등록 성공!')
              router.push('/')
            } else {
              alert('게시물 등록에 실패했습니다.')
              router.push('/')
            }
          })
          .catch(() => {
            console.log('err!!!')
          })
      }
      if (type === 'rewriting') {
        console.log('param : ' + no + title + contents)
        axios
          .put('/updateItem', null, {
            params: {
              no: no,
              title: title,
              contents: contents
            }
          })
          .then((res) => {
            if (String(res.data) === 'false') {
              console.log('실패! : ' + res.data)
              alert('수정에 실패하였습니다.')
            }
            if (String(res.data) === 'true') {
              console.log('수정 완료! : ' + res.data)
              alert('수정 성공!')
            }
            router.push('/')
          })
          .catch((res) => {
            console.log('실패! : ' + res)
            alert('수정에 실패하였습니다.')
            router.push(0)
          })
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
  height: 600px;
  overflow: scroll;
  overflow-x: hidden;
}
</style>
