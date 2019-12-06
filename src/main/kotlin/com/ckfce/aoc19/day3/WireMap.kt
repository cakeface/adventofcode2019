package com.ckfce.aoc19.day3

import kotlin.math.abs

class WireMap {

    val red = Wire.Red(mutableSetOf())
    val blue = Wire.Blue(mutableSetOf())

    fun firstIntersection(redLine: String, blueLine: String): Int {
        val redCommands = redLine.split(",")
        val blueCommands = blueLine.split(",")

        var curRed = Coord(0, 0)
        var curBlue = Coord(0, 0)
        var traveledRed = 0
        var traveledBlue = 0
        var i = 0

        while(true) {
            val nextRed = parseCommand(redCommands[i], curRed, red)
            val nextBlue = parseCommand(blueCommands[i], curBlue, blue)

            val found = intersections()
            if (found.isNotEmpty()) {
                if (found.size > 1) {
                    throw Exception("Did not handle multiple intersections in one step.")
                }
                val x = found.first()
                val incrementalRed = distance(curRed, x)
                val incrementalBlue = distance(curBlue, x)
                return traveledRed + incrementalRed + traveledBlue + incrementalBlue
            }
            traveledRed += distance(curRed, nextRed)
            traveledBlue += distance(curBlue, nextBlue)

            curRed = nextRed
            curBlue = nextBlue
            i++
            // Ignoring out of bound checks
        }
    }

    fun distance(c1: Coord, c2: Coord): Int {
        return abs(c2.x - c1.x) + abs(c2.y - c1.y)
    }

    fun closestIntersection(): Coord {
        val f = intersections().stream()
            .sorted(this::manhattanCompare)
            .findFirst()
        return f.get()
    }

    fun manhattanCompare(c1: Coord, c2:Coord): Int {
        val d1 = (abs(c1.x) + abs(c1.y))
        val d2 = (abs(c2.x) + abs(c2.y))
        return d1.compareTo(d2)
    }

    fun intersections(): Set<Coord> {
        return red.locations.intersect(blue.locations)
    }

    fun parse(line: String, wire: Wire) {
        val commands = line.split(",")
        var currentPosition = Coord(0,0)
        for (command in commands) {
            currentPosition = parseCommand(command, currentPosition, wire)
        }
    }

    /**
     * @return ending position
     */
    fun parseCommand(command: String, start: Coord, wire: Wire): Coord {
        val direction = command[0]
        val distance = command.substring(1).toInt()
        return when (direction) {
            'U' -> draw(start, distance, wire, this::up)
            'D' -> draw(start, distance, wire, this::down)
            'L' -> draw(start, distance, wire, this::left)
            'R' -> draw(start, distance, wire, this::right)
            else -> throw Exception("$command is not a valid direction to move. Expecting U, D, L, R")
        }
    }

    private fun draw(start: Coord, distance: Int, wire: Wire, move: (Coord, Int) -> Coord): Coord {
        var l = Coord(0,0)
        for(i in 1 .. distance) {
            l = move(start, i)
            wire.locations.add(l)
        }
        return l
    }

    private fun up(start: Coord, distance: Int): Coord {
        return Coord(start.x, start.y + distance)
    }

    private fun down(start: Coord, distance: Int): Coord {
        return Coord(start.x, start.y - distance)
    }

    private fun left(start: Coord, distance: Int): Coord {
        return Coord(start.x - distance, start.y)
    }

    private fun right(start: Coord, distance: Int): Coord {
        return Coord(start.x + distance, start.y)
    }
}



data class Coord(val x: Int, val y: Int)

sealed class Wire(val locations: MutableSet<Coord>) {
    class Red(locations: MutableSet<Coord>): Wire(locations)
    class Blue(locations: MutableSet<Coord>): Wire(locations)
}
