package com.alezzgo.socialmedia.ui

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp

object Extensions {
    @Composable
    operator fun PaddingValues.plus(other: PaddingValues): PaddingValues {
        val direction = LocalLayoutDirection.current
        return PaddingValues(
            top = this.calculateTopPadding() + other.calculateTopPadding(),
            start = this.calculateStartPadding(direction) + other.calculateStartPadding(direction),
            end = this.calculateEndPadding(direction) + other.calculateEndPadding(direction),
            bottom = this.calculateBottomPadding() + other.calculateBottomPadding(),
        )
    }
}