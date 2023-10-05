<script lang="ts">
enum Mutation {
  SRC = "update:src"
}
</script>
<script setup lang="ts">
import {ref} from "vue";

const props = defineProps<{ src: string }>()
const emit = defineEmits(Object.values(Mutation))
const input = ref<HTMLInputElement | null>(null)

const onSelectFile = () => {
  const files = input.value?.files
  if (files && files[0]) {
    const reader = new FileReader
    reader.onload = e => {
      emit(Mutation.SRC, e.target.result)
    }
    reader.readAsDataURL(files[0])
  }
}
</script>

<template>
  <div class="image-input"
       :style="{ 'background-image': `url(${props.src})` }"
       @click="input?.click()">
    <span v-if="!props.src" class="placeholder">
      Choose an Image
    </span>
    <input class="file-input"
           type="file"
           ref="input"
           @input="onSelectFile" />
  </div>
</template>

<style scoped>
.image-input {
  display: block;
  width: 185px;
  height: 185px;
  cursor: pointer;
  background-size: cover;
  background-position: center center;
  position: relative;
}
.image-input:before {
  position: absolute;
  content: "Edit";
  color: #ffffff;
  font-size: 18px;
  font-weight: 600;
  justify-content: center;
  align-items: center;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: #000000;
  opacity: 0.7;
  display: none;
}
.image-input:hover:before {
  display: flex;
}
.placeholder {
  background: #f0f0f0;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #333;
  font-size: 18px;
}
.placeholder:hover {
  background: #e0e0e0;
}
.file-input {
  display: none;
}
</style>