package com.ckfce.aoc19.day3

import com.ckfce.aoc19.AocRunner

class Day3Part2: AocRunner {
    override fun label(): String {
        return "Day 3, Part 2"
    }

    override fun run(): Int {
        val i = inputLines()
        val map = WireMapExact(i[0], i[1])
        map.parse()
        return map.fullClosestTraveled()
    }

    fun inputLines(): List<String> {
        val t = Day3Part2::class.java.getResource("input.txt").readText()
        return t.lines()
    }
}