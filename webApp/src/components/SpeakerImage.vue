<script lang="ts">
enum Mutation {
  SRC = "update:src"
}
</script>
<script setup lang="ts">
import {onMounted, watchEffect} from "vue";
import {renderSpeakerImage, updateProps} from "make-friends-with-kotlin-devs-common";

const CANVAS_ID = "SpeakerImage"
const props = defineProps<{ src: string }>()
const emit = defineEmits(Object.values(Mutation))

const onChangeImage = (newBase64: string) =>
    emit(Mutation.SRC, newBase64)


watchEffect(() =>
  updateProps(composeProps => {
    composeProps.base64 = props.src
  })
)

onMounted(() => renderSpeakerImage(CANVAS_ID, onChangeImage))

</script>

<template>
  <canvas :id="CANVAS_ID" width="185" height="185" class="image-input"></canvas>
</template>

<style scoped>
.image-input {
  display: block;
  cursor: pointer;
  position: relative;
}
</style>