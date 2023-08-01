package com.alezzgo.socialmedia.ui.screens.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alezzgo.socialmedia.ui.models.Chat
import com.alezzgo.socialmedia.ui.models.ChatMember
import com.alezzgo.socialmedia.ui.screens.destinations.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@NonRestartableComposable
@Destination
@RootNavGraph(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel : HomeViewModel = hiltViewModel()
) = LazyColumn(
    modifier = Modifier.fillMaxSize(), contentPadding = WindowInsets.displayCutout
        .union(WindowInsets.statusBars)
        .union(WindowInsets.navigationBars).asPaddingValues()
) {
    item { Text(modifier = Modifier, text = "Home") }

    val mockChat = Chat(
        id = 203040,
        members = listOf(
            ChatMember(userId = 0,"Alex"),
            ChatMember(userId = 1,"Stas"),
        )
    )

    item { Button(onClick = { navigator.navigate(DescriptionScreenDestination(chat = mockChat)) }) { Text("to description") } }
    item { Spacer(modifier = Modifier.size(90.dp)) } //todo fix
//    item { Mapus() } //todo fix
}