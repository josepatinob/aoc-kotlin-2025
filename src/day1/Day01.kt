package day1

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val directions: Pair<Char, Char> = Pair('L', 'R')
        var currentIndex = 50
        var zeroCount = 0

        input.forEach { rotation ->
            val rotationAmount = rotation.drop(1).toInt()
            when (rotation[0]) {
                directions.first -> {
                    repeat(rotationAmount) {
                        currentIndex--

                        if (currentIndex == -1) {
                            currentIndex = 99
                        }
                    }

                    if (currentIndex == 0) {
                        zeroCount++
                    }
                }
                directions.second -> {
                    repeat(rotationAmount) {
                        currentIndex++

                        if (currentIndex == 100) {
                            currentIndex = 0
                        }
                    }

                    if (currentIndex == 0) {
                        zeroCount++
                    }
                }
                else -> Unit
            }
        }

        return zeroCount
    }

    fun part2(input: List<String>): Int {
        val directions: Pair<Char, Char> = Pair('L', 'R')
        var currentIndex = 50
        var zeroCount = 0

        input.forEach { rotation ->
            val rotationAmount = rotation.drop(1).toInt()
            when (rotation[0]) {
                directions.first -> {
                    repeat(rotationAmount) {
                        currentIndex--

                        if (currentIndex == -1) {
                            currentIndex = 99
                        }

                        if (currentIndex == 0 && it != rotationAmount - 1) {
                            zeroCount++
                        }
                    }

                    if (currentIndex == 0) {
                        zeroCount++
                    }
                }
                directions.second -> {
                    repeat(rotationAmount) {
                        currentIndex++

                        if (currentIndex == 100) {
                            currentIndex = 0
                        }

                        if (currentIndex == 0 && it != rotationAmount - 1) {
                            zeroCount++
                        }
                    }

                    if (currentIndex == 0) {
                        zeroCount++
                    }
                }
                else -> Unit
            }
        }

        return zeroCount
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 3)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
