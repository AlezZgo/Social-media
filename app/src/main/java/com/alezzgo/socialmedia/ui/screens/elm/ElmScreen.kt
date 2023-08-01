package com.alezzgo.socialmedia.ui.screens.elm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.hilt.navigation.compose.hiltViewModel
import com.alezzgo.socialmedia.ui.models.Chat
import com.alezzgo.socialmedia.ui.screens.description.DescriptionViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@NonRestartableComposable
@Destination
@Composable
fun ElmScreen(
    navigator: DestinationsNavigator,
    viewModel: ElmViewModel = hiltViewModel(),
){


}