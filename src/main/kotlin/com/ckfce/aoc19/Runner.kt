package com.ckfce.aoc19

import com.ckfce.aoc19.day1.Day1
import com.ckfce.aoc19.day1.Day1Part2
import com.ckfce.aoc19.day1.ModuleMassCalculator

class Runner {

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {
			val day = day1Part2()
			println("${day.label()}: ${day.run()}")
		}

		fun dayRunners(): List<AocRunner> {
			return listOf(day1(), day1Part2())
		}

		fun day1(): AocRunner {
			return Day1(ModuleMassCalculator())
		}

		fun day1Part2(): AocRunner {
			return Day1Part2(ModuleMassCalculator())
		}
	}
}
