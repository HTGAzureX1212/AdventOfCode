package com.github.htgazurex1212.adventofcode.solution.year2022

import com.github.htgazurex1212.adventofcode.framework.AbstractAdventOfCodeSolution
import com.github.htgazurex1212.adventofcode.framework.AdventOfCode

@AdventOfCode(year = 2022, day = 3)
class AdventOfCodeYear2022Day3Solution : AbstractAdventOfCodeSolution(2022, 3) {
  override fun part1(): String {
    val lines = input()

    return lines.sumOf {
      val len = it.length / 2
      val first = it.substring(0, len)
      val second = it.substring(len)

      val intersect = first.toCharArray().intersect(second.asIterable().toSet())
      intersect.sumOf { c ->
        run {
          if (c.isUpperCase()) {
            c.code - 64 + 26
          } else if (c.isLowerCase()) {
            c.code - 96
          } else {
            throw Exception("unreachable code")
          }
        }
      }
    }.toString()
  }

  override fun part2(): String {
    val lines = input().toMutableList()

    var ans = 0
    while (lines.isNotEmpty()) {
      val line1 = lines.removeAt(0)
      val line2 = lines.removeAt(0)
      val line3 = lines.removeAt(0)

      val intersect1 = line1.toCharArray().intersect(line2.asIterable().toSet())
      val intersect2 = intersect1.toCharArray().intersect(line3.asIterable().toSet())

      ans += intersect2.sumOf { c ->
        run {
          if (c.isUpperCase()) {
            c.code - 64 + 26
          } else if (c.isLowerCase()) {
            c.code - 96
          } else {
            throw Exception("unreachable code")
          }
        }
      }
    }

    return ans.toString()
  }
}