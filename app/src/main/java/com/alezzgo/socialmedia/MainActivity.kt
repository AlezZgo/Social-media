package com.alezzgo.socialmedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.alezzgo.socialmedia.ui.CustomScaffold
import com.alezzgo.socialmedia.ui.Extensions.plus
import com.alezzgo.socialmedia.ui.theme.SocialMediaTheme


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            SocialMediaTheme {
                CustomScaffold(
//                    topBar = {
//                        TopAppBar(
//                            title = {
//                                Text(
//                                    modifier = Modifier,
//                                    text = "Title"
//                                )
//                            },
//                        )
//                    },

                    contentWindowInsets = WindowInsets(0.dp)
                ) { paddings, hasTopAppBar ->


                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddings),

                        contentPadding = if (hasTopAppBar) {
                            WindowInsets.navigationBars
                        } else {
                            WindowInsets.displayCutout
                                .union(WindowInsets.statusBars)
                                .union(WindowInsets.navigationBars)

                        }.asPaddingValues() + PaddingValues(8.dp)

                    ) {
                        item {
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                            Greeting("Hello")
                        }
                    }
                }
            }
        }
    }
}

@NonRestartableComposable
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) = OutlinedButton(onClick = { }) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SocialMediaTheme {
        Greeting("Android")
    }
}