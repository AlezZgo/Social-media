package com.alezzgo.socialmedia.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColors = lightColorScheme(
    primary = Light_primary,
    onPrimary = Light_onPrimary,
    primaryContainer = Light_primaryContainer,
    onPrimaryContainer = Light_onPrimaryContainer,
    secondary = Light_secondary,
    onSecondary = Light_onSecondary,
    secondaryContainer = Light_secondaryContainer,
    onSecondaryContainer = Light_onSecondaryContainer,
    tertiary = Light_tertiary,
    onTertiary = Light_onTertiary,
    tertiaryContainer = Light_tertiaryContainer,
    onTertiaryContainer = Light_onTertiaryContainer,
    error = Light_error,
    errorContainer = Light_errorContainer,
    onError = Light_onError,
    onErrorContainer = Light_onErrorContainer,
    background = Light_background,
    onBackground = Light_onBackground,
    surface = Light_surface,
    onSurface = Light_onSurface,
    surfaceVariant = Light_surfaceVariant,
    onSurfaceVariant = Light_onSurfaceVariant,
    outline = Light_outline,
    inverseOnSurface = Light_inverseOnSurface,
    inverseSurface = Light_inverseSurface,
    inversePrimary = Light_inversePrimary,
    surfaceTint = Light_surfaceTint,
    outlineVariant = Light_outlineVariant,
    scrim = Light_scrim,
)


private val DarkColors = darkColorScheme(
    primary = Dark_primary,
    onPrimary = Dark_onPrimary,
    primaryContainer = Dark_primaryContainer,
    onPrimaryContainer = Dark_onPrimaryContainer,
    secondary = Dark_secondary,
    onSecondary = Dark_onSecondary,
    secondaryContainer = Dark_secondaryContainer,
    onSecondaryContainer = Dark_onSecondaryContainer,
    tertiary = Dark_tertiary,
    onTertiary = Dark_onTertiary,
    tertiaryContainer = Dark_tertiaryContainer,
    onTertiaryContainer = Dark_onTertiaryContainer,
    error = Dark_error,
    errorContainer = Dark_errorContainer,
    onError = Dark_onError,
    onErrorContainer = Dark_onErrorContainer,
    background = Dark_background,
    onBackground = Dark_onBackground,
    surface = Dark_surface,
    onSurface = Dark_onSurface,
    surfaceVariant = Dark_surfaceVariant,
    onSurfaceVariant = Dark_onSurfaceVariant,
    outline = Dark_outline,
    inverseOnSurface = Dark_inverseOnSurface,
    inverseSurface = Dark_inverseSurface,
    inversePrimary = Dark_inversePrimary,
    surfaceTint = Dark_surfaceTint,
    outlineVariant = Dark_outlineVariant,
    scrim = Dark_scrim,
)

@Composable
fun SocialMediaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                window.isNavigationBarContrastEnforced = false
            }
            window.statusBarColor = Color.Transparent.toArgb()

            window.navigationBarColor = Color.Transparent.toArgb()
            // invert status bar colors
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = !darkTheme

        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}


@Preview(showBackground = true)
@Composable
private fun ColorsPreview() {
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        SocialMediaTheme(
            darkTheme = false
        ) {
            val colors = listOf(
                "primary" to MaterialTheme.colorScheme.primary,
                "onPrimary" to MaterialTheme.colorScheme.onPrimary,
                "primaryContainer" to MaterialTheme.colorScheme.primaryContainer,
                "onPrimaryContainer" to MaterialTheme.colorScheme.onPrimaryContainer,
                "inversePrimary" to MaterialTheme.colorScheme.inversePrimary,
                "secondary" to MaterialTheme.colorScheme.secondary,
                "onSecondary" to MaterialTheme.colorScheme.onSecondary,
                "secondaryContainer" to MaterialTheme.colorScheme.secondaryContainer,
                "onSecondaryContainer" to MaterialTheme.colorScheme.onSecondaryContainer,
                "tertiary" to MaterialTheme.colorScheme.tertiary,
                "onTertiary" to MaterialTheme.colorScheme.onTertiary,
                "tertiaryContainer" to MaterialTheme.colorScheme.tertiaryContainer,
                "onTertiaryContainer" to MaterialTheme.colorScheme.onTertiaryContainer,
                "background" to MaterialTheme.colorScheme.background,
                "onBackground" to MaterialTheme.colorScheme.onBackground,
                "surface" to MaterialTheme.colorScheme.surface,
                "onSurface" to MaterialTheme.colorScheme.onSurface,
                "surfaceVariant" to MaterialTheme.colorScheme.surfaceVariant,
                "onSurfaceVariant" to MaterialTheme.colorScheme.onSurfaceVariant,
                "surfaceTint" to MaterialTheme.colorScheme.surfaceTint,
                "inverseSurface" to MaterialTheme.colorScheme.inverseSurface,
                "inverseOnSurface" to MaterialTheme.colorScheme.inverseOnSurface,
                "error" to MaterialTheme.colorScheme.error,
                "onError" to MaterialTheme.colorScheme.onError,
                "errorContainer" to MaterialTheme.colorScheme.errorContainer,
                "onErrorContainer" to MaterialTheme.colorScheme.onErrorContainer,
                "outline" to MaterialTheme.colorScheme.outline,
                "outlineVariant" to MaterialTheme.colorScheme.outlineVariant,
                "scrim" to MaterialTheme.colorScheme.scrim,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                colors.forEach {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(24.dp),
                        color = it.second
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = it.first,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
        SocialMediaTheme(
            darkTheme = true
        ) {
            val colors = listOf(
                "primary" to MaterialTheme.colorScheme.primary,
                "onPrimary" to MaterialTheme.colorScheme.onPrimary,
                "primaryContainer" to MaterialTheme.colorScheme.primaryContainer,
                "onPrimaryContainer" to MaterialTheme.colorScheme.onPrimaryContainer,
                "inversePrimary" to MaterialTheme.colorScheme.inversePrimary,
                "secondary" to MaterialTheme.colorScheme.secondary,
                "onSecondary" to MaterialTheme.colorScheme.onSecondary,
                "secondaryContainer" to MaterialTheme.colorScheme.secondaryContainer,
                "onSecondaryContainer" to MaterialTheme.colorScheme.onSecondaryContainer,
                "tertiary" to MaterialTheme.colorScheme.tertiary,
                "onTertiary" to MaterialTheme.colorScheme.onTertiary,
                "tertiaryContainer" to MaterialTheme.colorScheme.tertiaryContainer,
                "onTertiaryContainer" to MaterialTheme.colorScheme.onTertiaryContainer,
                "background" to MaterialTheme.colorScheme.background,
                "onBackground" to MaterialTheme.colorScheme.onBackground,
                "surface" to MaterialTheme.colorScheme.surface,
                "onSurface" to MaterialTheme.colorScheme.onSurface,
                "surfaceVariant" to MaterialTheme.colorScheme.surfaceVariant,
                "onSurfaceVariant" to MaterialTheme.colorScheme.onSurfaceVariant,
                "surfaceTint" to MaterialTheme.colorScheme.surfaceTint,
                "inverseSurface" to MaterialTheme.colorScheme.inverseSurface,
                "inverseOnSurface" to MaterialTheme.colorScheme.inverseOnSurface,
                "error" to MaterialTheme.colorScheme.error,
                "onError" to MaterialTheme.colorScheme.onError,
                "errorContainer" to MaterialTheme.colorScheme.errorContainer,
                "onErrorContainer" to MaterialTheme.colorScheme.onErrorContainer,
                "outline" to MaterialTheme.colorScheme.outline,
                "outlineVariant" to MaterialTheme.colorScheme.outlineVariant,
                "scrim" to MaterialTheme.colorScheme.scrim,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                colors.forEach {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(24.dp),
                        color = it.second,
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = it.first,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}