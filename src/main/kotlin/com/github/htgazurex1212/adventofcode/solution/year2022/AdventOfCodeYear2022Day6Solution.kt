package com.github.htgazurex1212.adventofcode.solution.year2022

import com.github.htgazurex1212.adventofcode.framework.AbstractAdventOfCodeSolution
import com.github.htgazurex1212.adventofcode.framework.AdventOfCode

@AdventOfCode(year = 2022, day = 6)
class AdventOfCodeYear2022Day6Solution : AbstractAdventOfCodeSolution(2022, 6) {
  override fun part1(): String {
    val lines = input()

    val iter = lines[0].windowed(4, 1)
    var num = 3
    for (it in iter) {
      num += 1
      if (it.allUnique()) {
        break
      }
    }

    return num.toString()
  }

  override fun part2(): String {
    val lines = input()

    val iter = lines[0].windowed(14, 1)
    var num = 13
    for (it in iter) {
      num += 1
      if (it.allUnique()) {
        break
      }
    }

    return num.toString()
  }
}

fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)
