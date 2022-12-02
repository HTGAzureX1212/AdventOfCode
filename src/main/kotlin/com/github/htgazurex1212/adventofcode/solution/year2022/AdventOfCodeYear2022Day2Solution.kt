package com.github.htgazurex1212.adventofcode.solution.year2022

import com.github.htgazurex1212.adventofcode.framework.AbstractAdventOfCodeSolution
import com.github.htgazurex1212.adventofcode.framework.AdventOfCode

@AdventOfCode(year = 2022, day = 2)
class AdventOfCodeYear2022Day2Solution : AbstractAdventOfCodeSolution(2022, 2) {
  override fun part1(): String {
    val lines = input()

    return lines.sumOf {
      runRpsP1(it[0], it[2])
    }.toString()
  }

  override fun part2(): String {
    val lines = input()

    return lines.map {
      it[0] to (when (it[0] to it[2]) {
        'A' to 'X' -> 'C'
        'A' to 'Y' -> 'A'
        'A' to 'Z' -> 'B'
        'B' to 'X' -> 'A'
        'B' to 'Y' -> 'B'
        'B' to 'Z' -> 'C'
        'C' to 'X' -> 'B'
        'C' to 'Y' -> 'C'
        'C' to 'Z' -> 'A'
        else -> throw Exception("unreachable code")
      })
    }.sumOf {
      runRpsP2(it.first, it.second)
    }.toString()
  }
}

fun runRpsP1(l: Char, r: Char): Int = (r.code - 87) + (3 * cmpRpsP1(l, r))

fun runRpsP2(l: Char, r: Char): Int = (r.code - 64) + (3 * cmpRpsP2(l, r))

fun cmpRpsP1(l: Char, r: Char): Int {
  return when (l to r) {
    'A' to 'Y' -> 2
    'B' to 'Z' -> 2
    'C' to 'X' -> 2
    'A' to 'X' -> 1
    'B' to 'Y' -> 1
    'C' to 'Z' -> 1
    else -> 0
  }
}

fun cmpRpsP2(l: Char, r: Char): Int {
  return when (l to r) {
    'A' to 'A' -> 1
    'A' to 'B' -> 2
    'B' to 'B' -> 1
    'B' to 'C' -> 2
    'C' to 'A' -> 2
    'C' to 'C' -> 1
    else -> 0
  }
}
