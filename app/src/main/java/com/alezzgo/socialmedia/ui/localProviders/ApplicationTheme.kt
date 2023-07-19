package com.alezzgo.socialmedia.ui.localProviders

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable

enum class Theme {
    Dark, Light, Auto
}

class ApplicationTheme(theme: Theme) {
    private val _appTheme = mutableStateOf(value = theme, policy = neverEqualPolicy())
    val appTheme get() = _appTheme.value

    fun setTheme(theme : Theme) { _appTheme.value = theme }
}

private val Saver = listSaver<ApplicationTheme, Any>(
    save = { listOf(it.appTheme) },
    restore = { ApplicationTheme(it[0] as Theme) }
)

@Composable
fun rememberApplicationTheme(theme: Theme = Theme.Auto) = rememberSaveable(saver = Saver) {
    ApplicationTheme(theme)
}