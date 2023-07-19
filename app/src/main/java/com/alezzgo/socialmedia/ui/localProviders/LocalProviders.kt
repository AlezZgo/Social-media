package com.alezzgo.socialmedia.ui.localProviders

import androidx.compose.runtime.compositionLocalOf
import com.alezzgo.socialmedia.ui.localProviders.ApplicationTheme

val LocalTheme = compositionLocalOf<ApplicationTheme> { error("There is no theme") }