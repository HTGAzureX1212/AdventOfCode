package com.github.htgazurex1212.adventofcode.framework.exceptions

import kotlin.reflect.KClass
import kotlin.reflect.jvm.jvmName

class SolutionClassIsNotAnnotatedByRequiredAnnotationAdventOfCodeAnnotationException(clazz: KClass<*>) : Exception("solution class ${clazz.jvmName} is not annotated by required annotation: AdventOfCode")