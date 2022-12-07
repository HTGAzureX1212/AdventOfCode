package com.github.htgazurex1212.adventofcode.solution.year2022

import com.github.htgazurex1212.adventofcode.framework.AbstractAdventOfCodeSolution
import com.github.htgazurex1212.adventofcode.framework.AdventOfCode

@AdventOfCode(year = 2022, day = 7)
class AdventOfCodeYear2022Day7Solution : AbstractAdventOfCodeSolution(2022, 7) {
  override fun part1(): String {
    val lines = input().iterator()
    var pwd = ""
    val sizes = mutableMapOf<String, Int>()

    var inLs = false
    while (lines.hasNext()) {
      val line = lines.next()
      // is command
      if (line.startsWith("$ ")) {
        val cmd = line.substring(2 until line.length)
        when (cmd.substring(0 until 2)) {
          "cd" -> {
            val location = cmd.substring(3 until cmd.length)

            when (location) {
              ".." -> {
                val lastSlash = pwd.indexOfLast { it == '/' }
                pwd = pwd.substring(0 until lastSlash)

                if (pwd.isEmpty())
                  pwd += "/"
              }
              "/" -> {
                // is root
                pwd = "/"
              }
              else -> {
                // go deep one dir
                pwd += "/$location"
              }
            }

            inLs = false
          }
          "ls" -> {
            if (!sizes.containsKey(pwd))
              sizes[pwd] = 0

            inLs = true
          }
        }
      } else if (inLs) {
        if (line.startsWith("dir"))
          continue
        val fileSize = line.split(" ")[0].toInt()
        sizes[pwd] = sizes[pwd]!! + fileSize

        // go back until is root
        var tempPwd = pwd

        while (tempPwd.isNotEmpty()) {
          val lastSlash = tempPwd.indexOfLast { it == '/' }
          tempPwd = tempPwd.substring(0 until lastSlash)

          try {
            sizes[tempPwd] = sizes[tempPwd]!! + fileSize
          } catch (_: NullPointerException) {
            sizes[tempPwd] = fileSize
          }
        }
      }
    }

    return sizes.values.filter {
      it <= 100000
    }.sum().toString()
  }

  override fun part2(): String {
    val lines = input().iterator()
    var pwd = ""
    val sizes = mutableMapOf<String, Int>()

    var inLs = false
    while (lines.hasNext()) {
      val line = lines.next()
      // is command
      if (line.startsWith("$ ")) {
        val cmd = line.substring(2 until line.length)
        when (cmd.substring(0 until 2)) {
          "cd" -> {
            val location = cmd.substring(3 until cmd.length)

            when (location) {
              ".." -> {
                val lastSlash = pwd.indexOfLast { it == '/' }
                pwd = pwd.substring(0 until lastSlash)

                if (pwd.isEmpty())
                  pwd += "/"
              }
              "/" -> {
                // is root
                pwd = "/"
              }
              else -> {
                // go deep one dir
                pwd += "/$location"
              }
            }

            inLs = false
          }
          "ls" -> {
            if (!sizes.containsKey(pwd))
              sizes[pwd] = 0

            inLs = true
          }
        }
      } else if (inLs) {
        if (line.startsWith("dir"))
          continue
        val fileSize = line.split(" ")[0].toInt()
        sizes[pwd] = sizes[pwd]!! + fileSize

        // go back until is root
        var tempPwd = pwd

        while (tempPwd.isNotEmpty()) {
          val lastSlash = tempPwd.indexOfLast { it == '/' }
          tempPwd = tempPwd.substring(0 until lastSlash)

          try {
            sizes[tempPwd] = sizes[tempPwd]!! + fileSize
          } catch (_: NullPointerException) {
            sizes[tempPwd] = fileSize
          }
        }
      }
    }

    val needed = sizes["/"]!! - 40000000
    return sizes.values.filter {
      it > needed
    }.min().toString()
  }
}