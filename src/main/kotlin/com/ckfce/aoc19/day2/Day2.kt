package com.ckfce.aoc19.day2

import com.ckfce.aoc19.AocRunner

class Day2: AocRunner {
    override fun label(): String {
        return "Day 2"
    }

    override fun run(): Int {
        val shipsComputer = ShipsComputer(12, 2)
        return shipsComputer.run()
    }
}