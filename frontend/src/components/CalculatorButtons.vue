<script setup>
const { buttonText } = defineProps(['buttonText'])
const emit = defineEmits(['button-click'])

const handleButtonClick = () => {
  emit('button-click', buttonText)
}
</script>

<template>
  <button class="calculator-button" @click="handleButtonClick">
    {{ buttonText }}
  </button>
</template>

<style scoped>
.calculator-button {
  width: 60px;
  height: 60px;
  font-size: 24px;
  margin: 5px;
  background-color: #aff4cc;
  border: 1px solid #aff4cc;
  border-radius: 10px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.calculator-button:hover {
  background-color: #3db877;
}
</style>
