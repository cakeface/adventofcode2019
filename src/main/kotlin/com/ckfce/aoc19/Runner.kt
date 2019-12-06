package com.ckfce.aoc19

import com.ckfce.aoc19.day1.Day1
import com.ckfce.aoc19.day1.Day1Part2
import com.ckfce.aoc19.day1.ModuleMassCalculator
import com.ckfce.aoc19.day2.Day2
import com.ckfce.aoc19.day2.Day2Part2
import com.ckfce.aoc19.day3.Day3
import com.ckfce.aoc19.day3.Day3Part2

class Runner {

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {
			val day = Day3Part2()
			println("${day.label()}: ${day.run()}")
		}

		fun dayRunners(): List<AocRunner> {
			return listOf(day1(), day1Part2())
		}

		fun day2Part2(): AocRunner {
			return Day2Part2()
		}

		fun day2(): AocRunner {
			return Day2()
		}

		fun day1(): AocRunner {
			return Day1(ModuleMassCalculator())
		}

		fun day1Part2(): AocRunner {
			return Day1Part2(ModuleMassCalculator())
		}
	}
}
