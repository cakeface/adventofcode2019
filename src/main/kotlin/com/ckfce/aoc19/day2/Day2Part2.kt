package com.ckfce.aoc19.day2

import com.ckfce.aoc19.AocRunner


class Day2Part2: AocRunner {
    override fun label(): String {
        return "Day 2 Part 2"
    }

    override fun run(): Int {

        val inputSearcher = InputSearcher(19690720)
        val found = inputSearcher.search()

        return 100 * found.noun + found.verb
    }
}

