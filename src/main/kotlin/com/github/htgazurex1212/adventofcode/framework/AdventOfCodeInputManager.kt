package com.github.htgazurex1212.adventofcode.framework

import java.io.File

class AdventOfCodeInputManager {
  companion object {
    fun getInput(year: Int, day: Int): File = File("src/main/text/adventInput/year$year/day$day")
  }
}