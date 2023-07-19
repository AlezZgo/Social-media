package com.alezzgo.socialmedia.ui.ext

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.union
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import com.tynkovski.privateMessenger.utils.ext.empty
import com.tynkovski.privateMessenger.utils.ext.horizontalCutout
import com.tynkovski.privateMessenger.utils.ext.horizontalNavigationBars
import com.tynkovski.privateMessenger.utils.ext.horizontalStatusBars
import com.tynkovski.privateMessenger.utils.ext.verticalCutout
import com.tynkovski.privateMessenger.utils.ext.verticalNavigationBars

inline fun Modifier.chose(
    value: Boolean,
    block: Modifier.() -> Modifier,
    another: Modifier.() -> Modifier
): Modifier = if (value) block.invoke(this) else another.invoke(this)

inline fun Modifier.ifTrue(
    value: Boolean,
    block: Modifier.() -> Modifier,
): Modifier = if (value) block.invoke(this) else this

inline fun Modifier.ifFalse(
    value: Boolean,
    block: Modifier.() -> Modifier,
): Modifier = if (value.not()) block.invoke(this) else this

fun Modifier.clearingFocusClickable(): Modifier = composed {
    val focusManager = LocalFocusManager.current
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = focusManager::clearFocus
    )
}

fun Modifier.insetsAsPaddings(
    statusBars: Boolean,
    navigationBars: Boolean,
    displayCutout: Boolean
): Modifier = composed {
    val p1 = WindowInsets.empty
    val p2 = if (statusBars) p1.union(WindowInsets.statusBars) else p1
    val p3 = if (navigationBars) p2.union(WindowInsets.navigationBars) else p2
    val p4 = if (displayCutout) p3.union(WindowInsets.displayCutout) else p3
    padding(p4.asPaddingValues())
}

fun Modifier.horizontalNavigationBarsWithCutoutPadding(): Modifier = composed {
    padding(
        WindowInsets.horizontalNavigationBars.union(WindowInsets.horizontalCutout).asPaddingValues()
    )
}

fun Modifier.verticalNavigationBarsWithCutoutPadding(): Modifier = composed {
    padding(
        WindowInsets.verticalNavigationBars.union(WindowInsets.verticalCutout).asPaddingValues()
    )
}

fun Modifier.verticalNavigationBarsPadding(): Modifier = composed {
    padding(WindowInsets.verticalNavigationBars.asPaddingValues())
}

fun Modifier.horizontalNavigationBarsPadding(): Modifier = composed {
    padding(WindowInsets.horizontalNavigationBars.asPaddingValues())
}

fun Modifier.horizontalStatusBarsPadding(): Modifier = composed {
    padding(WindowInsets.horizontalStatusBars.asPaddingValues())
}

fun Modifier.horizontalCutoutPadding(): Modifier = composed {
    padding(WindowInsets.horizontalCutout.asPaddingValues())
}

