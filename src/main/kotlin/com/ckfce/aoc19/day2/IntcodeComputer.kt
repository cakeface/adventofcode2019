package com.ckfce.aoc19.day2

class IntcodeComputer(
    var pointer: Int = 0,
    var memory: MutableList<Int> ) {

    fun run() {
        var state: State = State.Ready(pointer, memory)
        while (state !is State.Halt) {
            state = state.click()
        }
    }
}

/**
 * So this is like a state machine of the computer. It runs through the various ops
 * and they transition it to a new state. After performing operations return to the ready
 * state. Ready has a map of what state to transition to by opcode. The operation states
 * are responsible for incrementing the pointer.
 */
sealed class State(val pointer: Int, val memory: MutableList<Int>) {

    abstract fun click(): State

    class Ready(pointer: Int, memory: MutableList<Int>) : State(pointer, memory) {
        override fun click(): State {
            val opCode = memory[pointer]
            when(opCode) {
                1 -> return Add(pointer, memory)
                2 -> return Multiply(pointer, memory)
                99 -> return Halt(pointer, memory)
                else -> return Halt(pointer, memory)
            }
        }
    }

    class Add(pointer: Int, memory: MutableList<Int>) : State(pointer, memory) {
        override fun click(): State {
            val inputPosA = memory[pointer + 1]
            val inputPosB = memory[pointer + 2]
            val outputPos = memory[pointer + 3]
            memory[outputPos] = memory[inputPosA] + memory[inputPosB]
            return Ready(pointer + 4, memory)
        }
    }

    class Multiply(pointer: Int, memory: MutableList<Int>) : State(pointer, memory) {
        override fun click(): State {
            val inputPosA = memory[pointer + 1]
            val inputPosB = memory[pointer + 2]
            val outputPos = memory[pointer + 3]
            memory[outputPos] = memory[inputPosA] * memory[inputPosB]
            return Ready(pointer + 4, memory)
        }
    }

    class Halt(pointer: Int, memory: MutableList<Int>) : State(pointer, memory) {
        override fun click(): State {
            throw Error("Don't click a halted computer.")
        }
    }
}
