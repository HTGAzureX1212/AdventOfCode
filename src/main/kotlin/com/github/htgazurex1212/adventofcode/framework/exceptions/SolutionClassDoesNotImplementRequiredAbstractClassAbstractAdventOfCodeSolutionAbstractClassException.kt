package com.github.htgazurex1212.adventofcode.framework.exceptions

import kotlin.reflect.KClass
import kotlin.reflect.jvm.jvmName

class SolutionClassDoesNotImplementRequiredAbstractClassAbstractAdventOfCodeSolutionAbstractClassException(clazz: KClass<*>)
  : Exception("solution class ${clazz.jvmName} does not implement required abstract class: AbstractAdventOfCodeSolution")