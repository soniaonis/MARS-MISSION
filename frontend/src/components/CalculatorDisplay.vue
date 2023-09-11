<script setup>
import { defineProps } from 'vue'

const { displayText } = defineProps(['displayText'])
</script>

<template>
  <div class="display">
    <p>{{ displayText }}</p>
  </div>
</template>

<style scoped>
.display {
  background-color: #e3f1e9;
  padding: 15px;
  text-align: right;
  font-size: 24px;
  border: 2px solid #aff4cc;
  border-radius: 5px;
  margin: 10px auto;
  max-width: 400px;
}
</style>