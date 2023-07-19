package com.alezzgo.socialmedia.ui.ext

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

fun Color.alpha(alpha: Float) = this.copy(alpha = alpha)
val Color.dimmed @Composable get() = this.alpha(0.06f)

val Color.contentColor get() = if (this.luminance() < 0.5f) Color.White else Color.Black

