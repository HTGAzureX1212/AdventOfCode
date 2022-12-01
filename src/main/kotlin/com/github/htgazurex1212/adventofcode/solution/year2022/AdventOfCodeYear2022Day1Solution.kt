package com.github.htgazurex1212.adventofcode.solution.year2022

import com.github.htgazurex1212.adventofcode.framework.AbstractAdventOfCodeSolution
import com.github.htgazurex1212.adventofcode.framework.AdventOfCode

@AdventOfCode(year = 2022, day = 1)
class AdventOfCodeYear2022Day1Solution : AbstractAdventOfCodeSolution(2022, 1) {
  override fun part1(): String {
    val lines = input()

    val elves = mutableListOf<Elf>()
    var elf = Elf(0)
    for (line in lines) {
      if (line.isEmpty()) {
        elves.add(elf)
        elf = Elf(0)
        continue
      }

      elf.calories += line.trim().toInt()
    }

    return elves.maxOfOrNull { it.calories }.toString()
  }

  override fun part2(): String {
    val lines = input()

    val elves = mutableListOf<Elf>()
    var elf = Elf(0)
    for (line in lines) {
      if (line.isEmpty()) {
        elves.add(elf)
        elf = Elf(0)
        continue
      }

      elf.calories += line.trim().toInt()
    }

    elves.sortByDescending { it.calories }
    return (elves[0].calories + elves[1].calories + elves[2].calories).toString()
  }
}

class Elf(var calories: Int)
