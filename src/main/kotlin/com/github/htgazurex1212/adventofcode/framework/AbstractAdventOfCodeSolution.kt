package com.github.htgazurex1212.adventofcode.framework

abstract class AbstractAdventOfCodeSolution(private val year: Int, private val day: Int) {
  fun input(): List<String> = AdventOfCodeInputManager.getInput(year, day).readLines(Charsets.UTF_8)

  abstract fun part1(): String

  abstract fun part2(): String
}