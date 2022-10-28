package com.github.htgazurex1212.adventofcode.runner

import com.github.htgazurex1212.adventofcode.framework.AdventOfCode
import com.github.htgazurex1212.adventofcode.framework.AdventOfCodeSolution
import com.github.htgazurex1212.adventofcode.framework.exceptions.SolutionClassDoesNotImplementRequiredInterfaceAdventOfCodeSolutionInterfaceException
import com.github.htgazurex1212.adventofcode.framework.exceptions.SolutionClassIsNotAnnotatedByRequiredAnnotationAdventOfCodeAnnotationException

class AdventOfCodeRunner {
  companion object {
    fun runSolution(year: Int, day: Int) {
      val clazz =
        Class.forName("com.github.htgazurex1212.adventofcode.solution.year$year.day$day.AdventOfCodeYear${year}Day${day}Solution")
      if (!AdventOfCodeSolution::class.java.isAssignableFrom(clazz))
        throw SolutionClassDoesNotImplementRequiredInterfaceAdventOfCodeSolutionInterfaceException(clazz.kotlin)

      if (!clazz.isAnnotationPresent(AdventOfCode::class.java))
        throw SolutionClassIsNotAnnotatedByRequiredAnnotationAdventOfCodeAnnotationException(clazz.kotlin)

      val part1 = clazz.getDeclaredMethod("part1").invoke(clazz.getDeclaredConstructor().newInstance()) as String
      println("Part 1 Answer: $part1")

      val part2 = clazz.getDeclaredMethod("part2").invoke(clazz.getDeclaredConstructor().newInstance()) as String
      println("Part 2 Answer: $part2")
    }
  }
}