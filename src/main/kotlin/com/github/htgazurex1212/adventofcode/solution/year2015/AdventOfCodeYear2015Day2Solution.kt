package com.github.htgazurex1212.adventofcode.solution.year2015

import com.github.htgazurex1212.adventofcode.framework.AbstractAdventOfCodeSolution
import com.github.htgazurex1212.adventofcode.framework.AdventOfCode
import kotlin.math.min

@AdventOfCode(year = 2015, day = 2)
class AdventOfCodeYear2015Day2Solution : AbstractAdventOfCodeSolution(2015, 2) {
  override fun part1(): String {
    val lines = input()
    val dimensions = lines.map { string -> string.split('x') }.toList()
    var sum = 0

    dimensions.forEach { dimension ->
      run {
        val l = dimension[0].toInt()
        val w = dimension[1].toInt()
        val h = dimension[2].toInt()

        sum += 2 * l * w + 2 * w * h + 2 * h * l + min(l * w, min(l * h, w * h))
      }
    }

    return sum.toString()
  }

  override fun part2(): String {
    val lines = input()
    val dimensions = lines.map { string -> string.split('x') }.toList()
    var sum = 0

    dimensions.forEach { dimension ->
      run {
        val l = dimension[0].toInt()
        val w = dimension[1].toInt()
        val h = dimension[2].toInt()

        sum += 2 * min(h + l, min(h + w, l + w)) + l * w * h
      }
    }

    return sum.toString()
  }
}