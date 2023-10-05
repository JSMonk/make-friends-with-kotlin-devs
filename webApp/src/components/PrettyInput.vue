<script setup lang="ts">
type Props = {
  value?: string,
  error?: string,
  singleLine?: boolean,
}

const emit = defineEmits(["change"])
const props = withDefaults<Props>(
    defineProps<Props>(),
    { value: "", singleLine: true, error: undefined }
)
</script>

<template>
  <p v-if="error" class="error-text">{{error}}</p>
  <input
      v-if="props.singleLine"
      :data-error="error"
      :class="[{error: error != null}, $attrs.class]"
      :value="props.value"
      @change="emit('change', $event)" />
  <p
     v-else
     :data-error="error"
     :class="[{error: error != null}, $attrs.class]"
     @blur="$event.target.value = $event.target.textContent; emit('change', $event)"
     contenteditable
     v-text="props.value"
     role="textbox" />
</template>

<style scoped>
input, [contenteditable] {
  display: block;
  border: none;
  padding-left: 15px;
  background-color: transparent;
  border-left: 2px solid white;
  outline: none;
  width: 100%;
}
input.error, [contenteditable].error {
  border-color: red;
}
.error-text {
  color: red;
  font-size: 0.6rem;
}
</style>