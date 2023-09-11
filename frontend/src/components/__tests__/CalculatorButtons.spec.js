import { describe, it, expect } from 'vitest'
import { mount } from '@vue/test-utils'
import CalculatorButtons from '@/components/CalculatorButtons.vue'

describe('CalculatorButtons.vue', () => {
  it('renders a button with the correct text', () => {
    const buttonText = '1'
    const wrapper = mount(CalculatorButtons, {
      props: {
        buttonText,
      },
    })
    expect(wrapper.text()).toContain(buttonText)
  })

  it('emits a custom event when clicked', async () => {
    const buttonText = '2'
    const wrapper = mount(CalculatorButtons, {
      props: {
        buttonText,
      },
    })
    await wrapper.trigger('click')
    expect(wrapper.emitted('button-click')).toBeTruthy()
    expect(wrapper.emitted('button-click')[0]).toEqual([buttonText])
  })
})