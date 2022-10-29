package com.github.htgazurex1212.adventofcode.solution.year2015

import com.github.htgazurex1212.adventofcode.framework.AdventOfCode
import com.github.htgazurex1212.adventofcode.framework.AbstractAdventOfCodeSolution
import java.lang.RuntimeException

@AdventOfCode(year = 2015, day = 1)
class AdventOfCodeYear2015Day1Solution : AbstractAdventOfCodeSolution(2015, 1) {
  override fun part1(): String {
    val lines = input()
    var floor = 0
    lines[0].chars().forEach { int ->
      when (int.toChar()) {
        '(' -> floor += 1
        ')' -> floor -= 1
      }
    }

    return floor.toString()
  }

  override fun part2(): String {
    val lines = input()
    var floor = 0

    for (i in (1..lines[0].length)) {
      when (lines[0][i - 1]) {
        '(' -> floor += 1
        ')' -> floor -= 1
      }

      if (floor < 0)
        return i.toString()
    }

    throw RuntimeException("unreachable branch reached")
  }
}