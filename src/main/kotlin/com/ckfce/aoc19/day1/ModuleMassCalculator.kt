package com.ckfce.aoc19.day1

class ModuleMassCalculator {

    fun fuelForModule(module: Module): FuelRequirement {
        val r = fuelForMass(module.mass)
        return FuelRequirement(r, module)
    }

    /**
     * OK apparently for part 2 we need to recursively sum the fuel requirements
     * for the fuel it's self until it's 0.
     */
    fun advancedFuelForModule(module: Module): FuelRequirement {
        return FuelRequirement(fuelForMassAndFuel(module.mass), module)
    }

    /**
     * Now we get to do recursion! Fun.
     */
    private fun fuelForMassAndFuel(mass: Int): Int {
        val fuel = fuelForMass(mass)

        // "Famous base case"
        if (fuel <= 0) return 0

        return fuel + fuelForMassAndFuel(fuel)
    }

    private fun fuelForMass(mass: Int): Int {
        return (mass / 3) - 2
    }
}

/**
 * A spaceship module with some integer quantity of mass.
 */
data class Module(val mass: Int)

/**
 * Fuel quantity required to launch a module.
 */
data class FuelRequirement(val quantity: Int, val module: Module)