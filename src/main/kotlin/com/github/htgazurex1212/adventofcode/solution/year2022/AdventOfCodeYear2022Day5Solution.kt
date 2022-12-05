package com.github.htgazurex1212.adventofcode.solution.year2022

import com.github.htgazurex1212.adventofcode.framework.AbstractAdventOfCodeSolution
import com.github.htgazurex1212.adventofcode.framework.AdventOfCode
import java.util.Stack

@AdventOfCode(year = 2022, day = 5)
class AdventOfCodeYear2022Day5Solution : AbstractAdventOfCodeSolution(2022, 5) {
  fun lines(): MutableList<String> {
    val lines = input().toMutableList()
    lines.removeAt(0)
    lines.removeAt(0)
    lines.removeAt(0)
    lines.removeAt(0)
    lines.removeAt(0)
    lines.removeAt(0)
    lines.removeAt(0)
    lines.removeAt(0)
    lines.removeAt(0)
    lines.removeAt(0)

    return lines
  }

  fun stacks(): MutableList<Stack<String>> {
    val stacks = mutableListOf<Stack<String>>()
    stacks.addAll(listOf(Stack<String>(), Stack<String>(), Stack<String>(), Stack<String>(), Stack<String>(), Stack<String>(), Stack<String>(), Stack<String>(), Stack<String>()))

    stacks[0].addAll(listOf("R", "S", "L", "F", "Q"))
    stacks[1].addAll(listOf("N", "Z", "Q", "G", "P", "T"))
    stacks[2].addAll(listOf("S", "M", "Q", "B"))
    stacks[3].addAll(listOf("T", "G", "Z", "J", "H", "C", "B", "Q"))
    stacks[4].addAll(listOf("P", "H", "M", "B", "N", "F", "S"))
    stacks[5].addAll(listOf("P", "C", "Q", "N", "S", "L", "V", "G"))
    stacks[6].addAll(listOf("W", "C", "F"))
    stacks[7].addAll(listOf("Q", "H", "G", "Z", "W", "V", "P", "M"))
    stacks[8].addAll(listOf("G", "Z", "D", "L", "C", "N", "R"))

    return stacks
  }

  override fun part1(): String {
    val lines = lines()
    val stacks = stacks()

    lines.forEach {
      val sections = it.split(" ")
      var noOfItems = sections[1].toInt()
      val from = sections[3].toInt() - 1
      val to = sections[5].toInt() - 1

      while (noOfItems > 0) {
        stacks[to].push(stacks[from].pop())
        noOfItems -= 1
      }
    }

    var output = ""
    stacks.forEach {
      output += it.pop()
    }

    return output
  }

  override fun part2(): String {
    val lines = lines()
    val stacks = stacks()

    lines.forEach {
      val sections = it.split(" ")
      var noOfItems = sections[1].toInt()
      val from = sections[3].toInt() - 1
      val to = sections[5].toInt() - 1

      val tempList = mutableListOf<String>()
      while (noOfItems > 0) {
        tempList.add(0, stacks[from].pop())
        noOfItems -= 1
      }

      stacks[to].addAll(tempList)
    }

    var output = ""
    stacks.forEach {
      output += it.pop()
    }

    return output
  }
}