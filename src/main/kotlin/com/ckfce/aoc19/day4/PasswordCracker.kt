package com.ckfce.aoc19.day4

import java.util.function.Function

class PasswordCracker(val rangeStart: Int, val rangeEnd: Int) {

    fun simpleSolution(): Int {
        val start = rangeStart
        val end = rangeEnd

        var count = 0
        for (i in start .. end) {
            if (validPassword(i)) {
                count++
            }
        }
        return count
    }

    fun validPassword(test: Int): Boolean {
        val ts = test.toString()
        val digits = ts.toCharArray()
        val d0 = digits[0].toInt()
        val d1 = digits[1].toInt()
        val d2 = digits[2].toInt()
        val d3 = digits[3].toInt()
        val d4 = digits[4].toInt()
        val d5 = digits[5].toInt()

        return allIncreasing(intArrayOf(d0, d1, d2, d3, d4, d5)) && hasDouble(intArrayOf(d0, d1, d2, d3, d4, d5))
    }

    fun allIncreasing(a: IntArray): Boolean {
        var last = a[0]
        for (i in 1 until a.size) {
            if (a[i] < last) return false
            last = a[i]
        }
        return true
    }


    fun hasDouble(a: IntArray): Boolean {
        val counts = mutableMapOf<Int, Int>()
        for (d in a) {
            counts.computeIfAbsent(d) { 0 }
            counts[d] = counts[d]!! + 1
        }
        for (e in counts.entries) {
            if (e.value == 2) return true
        }
        return false
    }
}