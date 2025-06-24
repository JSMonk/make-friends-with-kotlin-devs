<script lang="ts">
enum Mutation {
  SRC = "update:src"
}
</script>
<script setup lang="ts">
import {onMounted, watchEffect} from "vue";
import {renderSpeakerImage, updateProps} from "conference-cms-common";

const CONTAINER_ID = "SpeakerImage"
const props = defineProps<{ src: string }>()
const emit = defineEmits(Object.values(Mutation))

const onChangeImage = (newBase64: string) => {
  console.log("newBase64", newBase64)
  emit(Mutation.SRC, newBase64)
}

watchEffect(() =>
  updateProps(composeProps => {
    composeProps.base64 = props.src
  })
)

onMounted(() => renderSpeakerImage(CONTAINER_ID, onChangeImage))

</script>

<template>
  <div :id="CONTAINER_ID" class="image-input">
  </div>
</template>

<style scoped>
.image-input {
  display: block;
  cursor: pointer;
  position: relative;
  width: 185px;
  height: 185px;
}
</style>