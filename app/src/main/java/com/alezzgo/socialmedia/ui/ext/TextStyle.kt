package com.alezzgo.socialmedia.ui.ext

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit


val TextStyle.semiBold @Composable get() = this.copy(fontWeight = FontWeight.SemiBold)
val TextStyle.bold @Composable get() = this.copy(fontWeight = FontWeight.Bold)
val TextStyle.black @Composable get() = this.copy(fontWeight = FontWeight.Black)
val TextStyle.medium @Composable get() = this.copy(fontWeight = FontWeight.Medium)
val TextStyle.light @Composable get() = this.copy(fontWeight = FontWeight.Light)
val TextStyle.thin @Composable get() = this.copy(fontWeight = FontWeight.Thin)
val TextStyle.normal @Composable get() = this.copy(fontWeight = FontWeight.Normal)

@Composable
fun TextStyle.size(fontSize: TextUnit) = this.copy(fontSize = fontSize)

@Composable
fun TextStyle.lettering(letterSpacing: TextUnit) = this.copy(letterSpacing = letterSpacing)
