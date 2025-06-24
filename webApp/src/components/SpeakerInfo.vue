<script lang="ts">
enum Mutation {
  NAME = 'update:name',
  ABOUT = 'update:about',
  IMAGE = 'update:image',
  POSITION = 'update:position'
}
</script>

<script lang="ts" setup>
import SpeakerImage from "./SpeakerImage.vue"
import PrettyInput from "@/components/PrettyInput.vue";
import type {JsValidationResult, Talk} from "conference-cms-common";

const props = defineProps<{
  name: string,
  about: string,
  image: string,
  position: string,
  validations?: JsValidationResult<Talk>
}>()

const emit = defineEmits(Object.values(Mutation))
</script>

<template>
  <div class="container">
    <section class="image">
      <SpeakerImage :src="props.image" @update:src="emit(Mutation.IMAGE, $event)" />
    </section>
    <form class="speaker-info" action="" @submit.prevent>
      <PrettyInput
          class="name"
          :value="props.name"
          :error="props.validations?.validationErrorFor(['speaker', 'name'])"
          @change="emit(Mutation.NAME, $event.target.value)" />
      <PrettyInput
          class="position"
          :value="props.position"
          :error="props.validations?.validationErrorFor(['speaker', 'position'])"
          @change="emit(Mutation.POSITION, $event.target.value)" />
      <PrettyInput
          class="about"
          :single-line="false"
          :value="props.about"
          :error="props.validations?.validationErrorFor(['speaker', 'about'])"
          @change="emit(Mutation.ABOUT, $event.target.value)" />
    </form>
  </div>
</template>

<style scoped>
.image {
  margin-right: 50px;
}
.image img {
  width: 185px;
  height: 185px;
}
.speaker-info {
  width: 100%;
}
.speaker-info >>> .name {
  font-size: 30px;
  color: #ffffff;
  margin-bottom: 10px;
}
.speaker-info >>> .position {
  font-size: 16px;
  color: #ffffff;
  margin-bottom: 20px;
}
.speaker-info >>> .about {
  font-size: 14px;
  font-weight: 600;
  line-height: 1.46;
  color: #888888;
}
</style>