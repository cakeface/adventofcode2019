package com.ckfce.aoc19.day4

import org.assertj.core.api.Assertions
import org.junit.Test

class Day4UTest {

    @Test
    fun testHasDouble() {
        val pc = PasswordCracker(intArrayOf(1), intArrayOf(2));
        Assertions.assertThat(pc.hasDouble(intArrayOf(1, 2, 3, 4, 5, 6))).isFalse()
        Assertions.assertThat(pc.hasDouble(intArrayOf(2, 2, 4, 5, 6, 7))).isTrue()
        Assertions.assertThat(pc.hasDouble(intArrayOf(6, 3, 4, 3, 6, 7, 8, 5))).isFalse()
        Assertions.assertThat(pc.hasDouble(intArrayOf(6, 3, 4, 3, 6, 7, 5, 5))).isTrue()
    }

    @Test
    fun testNext() {
        val pc = PasswordCracker(intArrayOf(1), intArrayOf(2));
        Assertions.assertThat(pc.next(intArrayOf(1,0, 0)))
            .isEqualTo(intArrayOf(1, 0, 1))
        Assertions.assertThat(pc.next(intArrayOf(1, 9, 9, 9)))
            .isEqualTo(intArrayOf(2, 0, 0, 0))
    }
}