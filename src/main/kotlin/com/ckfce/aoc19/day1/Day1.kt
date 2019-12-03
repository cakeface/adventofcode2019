package com.ckfce.aoc19.day1

import com.ckfce.aoc19.AocRunner

class Day1(val moduleMassCalculator: ModuleMassCalculator): AocRunner {

    override fun label(): String {
        return "Day 1"
    }

    override fun run(): Int {
        val r = inputLines().stream()
            .filter { it.isNotEmpty() }
            .map { toModule(it) } // turn the string to a module with int mass
            .map { moduleMassCalculator.fuelForModule(it) }
            .map { it.quantity }
            .reduce { x, y -> x + y } // sum up all the fuel
        return r.get()
    }

    fun inputLines(): List<String> {
        val t = Day1::class.java.getResource("input.txt").readText()
        return t.lines()
    }

    fun toModule(input: String): Module {
        return Module(input.toInt())
    }
}