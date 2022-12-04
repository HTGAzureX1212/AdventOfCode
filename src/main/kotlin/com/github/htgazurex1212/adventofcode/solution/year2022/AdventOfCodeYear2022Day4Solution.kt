package com.github.htgazurex1212.adventofcode.solution.year2022

import com.github.htgazurex1212.adventofcode.framework.AbstractAdventOfCodeSolution
import com.github.htgazurex1212.adventofcode.framework.AdventOfCode

@AdventOfCode(year = 2022, day = 4)
class AdventOfCodeYear2022Day4Solution : AbstractAdventOfCodeSolution(2022, 4) {
  override fun part1(): String {
    val lines = input()
    return lines.sumOf {
      val leftAssign = it.split(",")[0]
      val rightAssign = it.split(",")[1]

      val a = leftAssign.split("-")[0].toInt()
      val b = leftAssign.split("-")[1].toInt()

      val c = rightAssign.split("-")[0].toInt()
      val d = rightAssign.split("-")[1].toInt()

      if ((a >= c && b <= d) || (c >= a && d <= b))
        1 as Int
      else
        0 as Int
    }.toString()
  }

  override fun part2(): String {
    val lines = input()
    return lines.sumOf {
      val leftAssign = it.split(",")[0]
      val rightAssign = it.split(",")[1]

      val a = leftAssign.split("-")[0].toInt()
      val b = leftAssign.split("-")[1].toInt()

      val c = rightAssign.split("-")[0].toInt()
      val d = rightAssign.split("-")[1].toInt()

      if ((a <= d && b >= c) || (c <= b && d >= a))
        1 as Int
      else
        0 as Int
    }.toString()
  }
}