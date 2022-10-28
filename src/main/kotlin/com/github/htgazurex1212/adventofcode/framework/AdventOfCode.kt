package com.github.htgazurex1212.adventofcode.framework

@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.CLASS])
annotation class AdventOfCode(val year: Int, val day: Int)
