package com.ckfce.aoc19

interface AocRunner {

    /**
     * A nice label, probably "Day 1"
     */
    fun label(): String

    /**
     * The thing to put into advento of code for todays input
     */
    fun run(): Int
}