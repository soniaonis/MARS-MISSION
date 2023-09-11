<script setup>
import { ref } from 'vue'
import * as math from 'mathjs'
import CalculatorDisplay from '../components/CalculatorDisplay.vue'
import CalculatorButtons from '../components/CalculatorButtons.vue'

const displayText = ref('')
const currentInput = ref('')
const buttons = ['1', '2', '3', '+', '4', '5', '6', '-', '7', '8', '9', '*', '0', '/', '.']

const handleButtonClick = (buttonText) => {
  currentInput.value += buttonText
  displayText.value = currentInput.value
}

const calculateResult = () => {
  try {
    const result = math.evaluate(currentInput.value)
    currentInput.value = result
    displayText.value = result
  } catch (error) {
    displayText.value = 'Error'
    currentInput.value = ''
  }
}

const resetCalculator = () => {
  displayText.value = ''
  currentInput.value = ''
}
</script>

<template>
  <div class="calculator">
    <CalculatorDisplay :displayText="displayText" />

    <div class="buttons">
      <button class="reset-button" @click="resetCalculator">C</button>
      <CalculatorButtons
        v-for="button in buttons"
        :key="button"
        :buttonText="button"
        @button-click="handleButtonClick"
      />
      <button class="calculate-button" @click="calculateResult">=</button>
    </div>
  </div>
</template>

<style scoped>
.calculator {
  max-width: 300px;
  margin: 0 auto;
}
.buttons {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 5px;
  margin-top: 10px;
}
.calculate-button {
  grid-column: span 2;
  background-color: #f96332;
  color: white;
  font-size: 24px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.calculate-button:hover {
  background-color: #e18569;
}
.reset-button {
  width: 60px;
  height: 60px;
  margin: 5px;
  background-color: #f96332;
  color: white;
  font-size: 24px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.reset-button:hover {
  background-color: #e18569;
}
</style>