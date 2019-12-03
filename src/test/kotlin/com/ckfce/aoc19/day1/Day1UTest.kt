package com.ckfce.aoc19.day1

import org.assertj.core.api.Assertions.*
import org.junit.Test

class Day1UTest {

    @Test
    fun calcDay1() {
        val day1 = Day1(ModuleMassCalculator())
        println(day1.run());
    }

    @Test
    fun testExamples() {
        assertMassToFuelReq(12, 2)
        assertMassToFuelReq(14, 2)
        assertMassToFuelReq(1969, 654)
        assertMassToFuelReq(100756, 33583)
    }

    private fun assertMassToFuelReq(mass: Int, fuel: Int) {
        val m = ModuleMassCalculator()
        val r = m.fuelForModule(Module(mass))
        assertThat(r.quantity).isEqualTo(fuel)
    }

    @Test
    fun testPart2Examples() {
        assertAdvancedMassToFuelReq(14, 2)
        assertAdvancedMassToFuelReq(1969, 966)
        assertAdvancedMassToFuelReq(100756, 50346)
    }

    fun assertAdvancedMassToFuelReq(mass: Int, fuel: Int) {
        val m = ModuleMassCalculator()
        val r = m.advancedFuelForModule(Module(mass))
        assertThat(r.quantity).isEqualTo(fuel)
    }
}
