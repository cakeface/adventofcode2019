package com.ckfce.aoc19.day4

import com.ckfce.aoc19.AocRunner

class Day4: AocRunner {
    override fun label(): String {
        return "Day 4"
    }

    override fun run(): Int {
        val passwordCracker = PasswordCracker(206938, 679128)
        return passwordCracker.simpleSolution()
    }
}