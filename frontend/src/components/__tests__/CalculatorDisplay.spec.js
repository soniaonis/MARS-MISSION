import { describe, it, expect } from 'vitest'
import { mount } from '@vue/test-utils'
import CalculatorDisplay from '@/components/CalculatorDisplay.vue'

describe('CalculatorDisplay.vue', () => {
    it('renders the display text correctly', () => {
      const displayText = '123 + 456'
      const wrapper = mount(CalculatorDisplay, {
        props: {
          displayText,
        },
      })
      expect(wrapper.text()).toContain(displayText)
    })
  })