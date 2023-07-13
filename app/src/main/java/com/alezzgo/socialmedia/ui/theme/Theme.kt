package com.alezzgo.socialmedia.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
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