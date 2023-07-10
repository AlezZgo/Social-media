package com.alezzgo.socialmedia

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.alezzgo.socialmedia.ui.theme.SocialMediaTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
//        val windowInsetsController =
//            ViewCompat.getWindowInsetsController(window.decorView)
//
//        windowInsetsController?.hide(WindowInsetsCompat.Type.systemBars())
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            SocialMediaTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "auth") {
                    navigation(startDestination = "login", route = "auth") {
                        composable("login") {
                            Column {
                                LazyColumn {
                                    item {
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                        Button(onClick = { }) { Text("go to register") }
                                    }

                                }
//                                Spacer(modifier = Modifier.size(48.dp))
//
//                                Spacer(modifier = Modifier.size(48.dp))
                                Text("login")
                                Button(onClick = { navController.navigate("register") }) {
                                    Text("go to register")
                                }
                            }
                        }
                        composable("register") {
                            Column {
                                Spacer(modifier = Modifier.size(48.dp))
                                Text("register")
                                Button(onClick = { navController.navigate("forgot_password") }) {
                                    Text("go to forgot_password")
                                }
                                val text = remember { mutableStateOf("123") }
                                OutlinedTextField(value = text.value, onValueChange = { string ->
                                    text.value = string
                                })
                                Button(onClick = { navController.navigate("") }) {
                                    Text("go to forgot_password")
                                }
                            }
                        }
                        composable("forgot_password") {
                            Column {
                                Spacer(modifier = Modifier.size(48.dp))
                                Text("forgot_password")
                                Button(onClick = { navController.navigate("main") }) {
                                    Text("go to main")
                                }
                            }
                        }
                    }
                    navigation(startDestination = "home", route = "main") {
                        composable("home") {
                            Column {
                                Spacer(modifier = Modifier.size(48.dp))
                                Text("home")
                                Button(onClick = { navController.navigate("calendar") }) {
                                    Text("go to calendar")
                                }
                            }

                        }
                        composable("calendar") {
                            Column {
                                Spacer(modifier = Modifier.size(48.dp))
                                Text("calendar")
//                                Button(onClick = { navController.navigate("login") }){
//                                    Text("go to login")
//                                }
                            }

                        }
                    }


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
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