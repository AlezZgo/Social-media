package com.alezzgo.socialmedia.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alezzgo.socialmedia.ui.ext.horizontalCutoutPadding
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.tynkovski.privateMessenger.utils.ext.plus

@OptIn(ExperimentalMaterial3Api::class)
@NonRestartableComposable
@Destination
@Composable
fun WorkshopScreen(
    navigator: DestinationsNavigator,
) = Scaffold(
    topBar = { TopAppBar(title = { Text("Workshop") }) }
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .horizontalCutoutPadding(),
        contentPadding = it + PaddingValues(8.dp)
    ) {
        item {
            repeat(100) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { }) { Text("to to") }
            }
        }
        item { Spacer(modifier = Modifier.size(90.dp)) } //todo fix
    }

}


