package com.github.htgazurex1212.adventofcode.framework.exceptions

import kotlin.reflect.KClass
import kotlin.reflect.jvm.jvmName

class SolutionClassDoesNotImplementRequiredInterfaceAdventOfCodeSolutionInterfaceException(clazz: KClass<*>) : Exception("solution class ${clazz.jvmName} does not implement required interface: AdventOfCodeSolution")