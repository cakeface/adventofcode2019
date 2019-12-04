package com.ckfce.aoc19.day2

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Run the ShipsComputer with inputs in range (0 to 99) until the matchResult
 * is found and then return a ShipsCodeResult with the noun, verb, and result.
 */
class InputSearcher(val matchResult: Int) {

    fun startSearching(): ReceiveChannel<ShipsComputerResult> {
        val channel = Channel<ShipsComputerResult>()
        for (i in 0 until 100) {
            for (j in 0 until 100) {
                GlobalScope.launch {
                    val shipsComputer = ShipsComputer(i, j)
                    channel.send(ShipsComputerResult(i, j, shipsComputer.run()))
                }
            }
        }
        return channel
    }

    fun filtertoMatching(searchResults: ReceiveChannel<ShipsComputerResult>): ReceiveChannel<ShipsComputerResult> {
        val channel = Channel<ShipsComputerResult>()
        GlobalScope.launch {
            for (r in searchResults) {
                if (r.result == matchResult) {
                    channel.send(r)
                }
            }
        }
        return channel
    }

    fun search(): ShipsComputerResult {
        val searchResults = startSearching()
        val onlyMatching = filtertoMatching(searchResults)
        var match: ShipsComputerResult = ShipsComputerResult(0,0,0)
        runBlocking {
            match = onlyMatching.receive()
        }
        return match
    }

}

data class ShipsComputerResult(val noun: Int, val verb: Int, val result: Int)