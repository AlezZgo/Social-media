package com.alezzgo.socialmedia.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alezzgo.socialmedia.ui.ext.horizontalCutoutPadding
import com.alezzgo.socialmedia.ui.localProviders.LocalTheme
import com.alezzgo.socialmedia.ui.localProviders.Theme
import com.alezzgo.socialmedia.ui.localProviders.rememberApplicationTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@NonRestartableComposable
@Destination
@Composable
fun SettingsScreen(
    navigator: DestinationsNavigator,
) = Box(
    modifier = Modifier.fillMaxSize().statusBarsPadding().navigationBarsPadding().horizontalCutoutPadding()
) {

    val state = LocalTheme.current

    Column(Modifier.selectableGroup())
    {
        Row {
            Text("Auto")
            RadioButton(
                selected = state.appTheme == Theme.Auto,
                onClick = { state.setTheme(Theme.Auto) }
            )
        }
        Row {
            Text("Dark")
            RadioButton(
                selected = state.appTheme == Theme.Dark,
                onClick = { state.setTheme(Theme.Dark) }
            )
        }
        Row {
            Text("Light")
            RadioButton(
                selected = state.appTheme == Theme.Light,
                onClick = { state.setTheme(Theme.Light) }
            )
        }

    }

}

