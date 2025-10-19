package com.example.lemonade.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = LemonPrimaryDark,
    primaryContainer = LemonPrimaryContainerDark,
    secondary = LemonSecondaryDark,
    tertiary = LemonTertiaryDark,
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    onPrimary = Color.Black
)

private val LightColorScheme = lightColorScheme(
    primary = LemonPrimary,
    primaryContainer = LemonPrimaryContainer,
    secondary = LemonSecondary,
    tertiary = LemonTertiary,
    background = Color(0xFFFFFDE7), // светлый фон всего экрана
    surface = Color(0xFFFFFFFF),
    onPrimary = Color.Black
)

@Composable
fun LemonadeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // оставить false чтобы твои цвета применялись
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
