/*
 * Copyright (c) 2021. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.letsPlot.intern.layer

import jetbrains.letsPlot.intern.Options
import kotlin.js.JsName

interface WithGroupOption {
    @JsName("groupOption")   // 'group' clashes with 'group()'
    val group: Any?

    fun group() = Options.of(
        "group" to group
    )
}