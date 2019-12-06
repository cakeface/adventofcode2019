package com.ckfce.aoc19.day3

import com.ckfce.aoc19.AocRunner
import com.ckfce.aoc19.day1.Day1
import kotlin.math.abs

class Day3 : AocRunner {

    override fun label(): String {
        return "Day 3"
    }

    override fun run(): Int {
        val wireMap = WireMap()
        val input = inputLines()
        wireMap.parse(input[0], wireMap.red)
        wireMap.parse(input[1], wireMap.blue)
        val closest = wireMap.closestIntersection()

        return abs(closest.x) + abs(closest.y)
    }


    fun inputLines(): List<String> {
        val t = Day3::class.java.getResource("input.txt").readText()
        return t.lines()
    }
}