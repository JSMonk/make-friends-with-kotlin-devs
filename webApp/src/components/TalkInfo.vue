<script lang="ts">
enum Mutation {
  TITLE = 'update:title',
  DESCRIPTION = 'update:description',
}
</script>
<script setup lang="ts">
import PrettyInput from "@/components/PrettyInput.vue";

const props = defineProps<{
  title: string,
  description: string,
}>()
const emit = defineEmits(Object.values(Mutation))
</script>

<template>
  <form class="talk-info" action="" @submit.prevent>
    <PrettyInput
        class="title"
        :value="props.title"
        @change="emit(Mutation.TITLE, $event.target.value)" />
    <PrettyInput
        class="description"
        :single-line="false"
        :value="props.description"
        @change="emit(Mutation.DESCRIPTION, $event.target.value)" />
  </form>
</template>

<style scoped>
form {
  width: 100%;
}
.talk-info >>> .title {
  color: #ffffff;
  font-size: 28px;
  font-weight: 500;
  margin: -4px 0 20px;
}
.talk-info >>> .description {
  color: #888888;
  font-size: 14px;
  font-weight: 600;
}
</style>