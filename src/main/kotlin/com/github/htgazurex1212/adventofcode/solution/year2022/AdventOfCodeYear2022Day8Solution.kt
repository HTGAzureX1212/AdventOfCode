package com.github.htgazurex1212.adventofcode.solution.year2022

import com.github.htgazurex1212.adventofcode.framework.AbstractAdventOfCodeSolution
import com.github.htgazurex1212.adventofcode.framework.AdventOfCode
import kotlin.streams.toList

@AdventOfCode(year = 2022, day = 8)
class AdventOfCodeYear2022Day8Solution : AbstractAdventOfCodeSolution(2022, 8) {
  override fun part1(): String {
    val trees = input().map {
      it.chars().toList()
    }.toList()

    var count = 0

    for (i in trees.indices) {
      val row = trees[i]

      for (j in row.indices) {
        if (isVisible(trees, i, j))
          count++
      }
    }

    return count.toString()
  }

  private fun isVisible(trees: List<List<Int>>, i: Int, j: Int): Boolean {
    val height = trees[i][j]
    val row = trees[i]

    if (i == 0 || i == row.size - 1)
      return true

    if (j == 0 || j == trees.size - 1)
      return true

    val left = row.subList(0, j).max()
    if (height > left)
      return true

    val right = row.subList(j + 1, trees.size).max()
    if (height > right)
      return true

    val up = trees.map { it[j] }.subList(0, i).max()
    if (height > up)
      return true

    val down = trees.map { it[j] }.subList(i + 1, trees.size).max()
    if (height > down)
      return true

    return false
  }

  override fun part2(): String {
    val trees = input().map {
      it.chars().toList()
    }.toList()

    var max = 0
    for (i in trees.indices) {
      for (j in trees[i].indices) {
        val thisScore = treeScore(trees, i, j)
        if (thisScore > max) {
          max = thisScore
        }
      }
    }

    return max.toString()
  }

  private fun treeScore(trees: List<List<Int>>, i: Int, j: Int): Int {
    val height = trees[i][j]
    val row = trees[i]

    if (i == 0 || i == row.size - 1)
      return 0

    if (j == 0 || j == trees.size - 1)
      return 0

    val left = row.subList(0, j).reversed()
    var lCount = 0
    for (l in left) {
      if (l < height) {
        lCount++
      } else if (l >= height) {
        lCount++
        break
      }
    }

    val right = row.subList(j + 1, trees.size)
    var rCount = 0
    for (r in right) {
      if (r < height) {
        rCount++
      } else if (r >= height) {
        rCount++
        break
      }
    }

    val up = trees.map { it[j] }.subList(0, i).reversed()
    var uCount = 0
    for (u in up) {
      if (u < height) {
        uCount++
      } else if (u >= height) {
        uCount++
        break
      }
    }

    val down = trees.map { it[j] }.subList(i + 1, trees.size)
    var dCount = 0
    for (d in down) {
      if (d < height) {
        dCount++
      } else if (d >= height) {
        dCount++
        break
      }
    }

    return lCount * rCount * uCount * dCount
  }
}