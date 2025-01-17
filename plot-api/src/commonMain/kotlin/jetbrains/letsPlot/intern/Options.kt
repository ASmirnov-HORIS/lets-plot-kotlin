/*
 * Copyright (c) 2021. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.letsPlot.intern

import jetbrains.letsPlot.intern.standardizing.MapStandardizing

class Options(map: Map<String, Any?>) {
    companion object {
        fun of(pair: Pair<String, Any?>) = Options(mapOf(pair))
        fun of(vararg pairs: Pair<String, Any?>) = Options(mapOf(*pairs))

        fun empty() = Options(emptyMap())
    }

    val map: Map<String, Any> = MapStandardizing.standardize(map)

    operator fun plus(other: Options) = union(other)

    fun has(k: String): Boolean {
        return map.containsKey(k)
    }

    fun get(k: String): Any {
        return map[k] ?: throw IllegalArgumentException("No such option: '$k'")
    }

    fun isEmpty() = map.isEmpty()

    fun union(other: Options) = Options(this.map + other.map)
}
