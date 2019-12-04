package com.ckfce.aoc19.day2

import org.assertj.core.api.Assertions
import org.junit.Test

class Day2UTest {

    @Test
    fun testExamples() {
        assertProgram(
            mutableListOf(1,9,10,3,2,3,11,0,99,30,40,50),
            mutableListOf(3500,9,10,70, 2,3,11,0,99,30,40,50))

        assertProgram(
            mutableListOf(1,0,0,0,99),
            mutableListOf(2,0,0,0,99))

        assertProgram(
            mutableListOf(1,1,1,4,99,5,6,0,99),
            mutableListOf(30,1,1,4,2,5,6,0,99))

    }

    fun assertProgram(initialState: MutableList<Int>, finalState: MutableList<Int>) {
        val cpu = IntcodeComputer(memory = initialState)
        cpu.run()
        Assertions.assertThat(cpu.memory).isEqualTo(finalState)
    }
}