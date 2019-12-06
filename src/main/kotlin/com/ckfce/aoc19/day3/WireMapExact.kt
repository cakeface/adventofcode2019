package com.ckfce.aoc19.day3

import kotlin.math.min

/**
 * I struggled to do day 3 part 2 because I couldn't follow the wires. This model
 * will not lose any information and will allow for following as well checking contents.
 */
class WireMapExact(val spec1: String, val spec2: String) {

    var wire1 = Wire(1)
    var wire2 = Wire(2)

    fun parse() {
        parse(spec1, wire1)
        parse(spec2, wire2)
    }

    /**
     * OK so my last one isn't working for some reason. Let's check all points. I guess there could
     * be an intersection that is not the closes on either route but overall is lower.
     */
    fun fullClosestTraveled(): Int {
        val intersections = wire1.points.intersect(wire2.points)
        var closest = Int.MAX_VALUE
        for (i in intersections) {
            val d1 = distanceTo(i, wire1)
            val d2 = distanceTo(i, wire2)
            val sum = d1 + d2
            closest = min(closest, sum)
        }
        return closest
    }

    fun distanceTo(point: Coord, wire: Wire): Int {
        return wire.points.indexOf(point) + 1
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
            wire.points.add(l)
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

    class Wire(val id: Int) {
        val points = mutableListOf<Coord>()
    }
}