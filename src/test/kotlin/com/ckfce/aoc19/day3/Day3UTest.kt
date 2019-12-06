package com.ckfce.aoc19.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day3UTest {

    @Test
    fun testParseCommandExample() {
        val wm = WireMap()
        val red = Wire.Red(mutableSetOf())
        var l = wm.parseCommand("R8", Coord(0, 0), red)
        l = wm.parseCommand("U5", l, red)
        l = wm.parseCommand("L5", l, red)
        l = wm.parseCommand("D3", l, red)
        assertThat(l).isEqualTo(Coord(3, 2))
    }

    @Test
    fun testParseExample() {
        val wm = WireMap()
        wm.parse("R8,U5,L5,D3", wm.red)
        assertThat(wm.red.locations).contains(Coord(3, 2))

        wm.parse("U7,R6,D4,L4", wm.blue)
        assertThat(wm.blue.locations).contains(Coord(6, 3))

        assertThat(wm.intersections()).containsExactlyInAnyOrder(Coord(3,3 ), Coord(6, 5))

        assertThat(wm.closestIntersection()).isEqualTo(Coord(3,3))
    }

    @Test
    fun testFirstIntersection() {
        val wm = WireMapExact("R8,U5,L5,D3", "U7,R6,D4,L4")
        wm.parse()
        val first = wm.fullClosestTraveled()
        assertThat(first).isEqualTo(30)
    }

    @Test
    fun testDistance() {
        val wm = WireMap()
        assertThat(wm.distance(Coord(-1, -1), Coord(-1, -2))).isEqualTo(1)
        assertThat(wm.distance(Coord(1, 1), Coord(1, 2))).isEqualTo(1)
        assertThat(wm.distance(Coord(1, 1), Coord(-1, -2))).isEqualTo(5)
    }

    @Test
    fun testFirstIntersection2() {
        val wm2 = WireMapExact("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
            "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")
        wm2.parse()
        val f2 = wm2.fullClosestTraveled()
        assertThat(f2).isEqualTo(410)
    }

    @Test
    fun testAnotherExample() {
        val wm = WireMapExact("R75,D30,R83,U83,L12,D49,R71,U7,L72",
            "U62,R66,U55,R34,D71,R55,D58,R83")
        wm.parse()
        assertThat(wm.fullClosestTraveled()).isEqualTo(610)
    }
}