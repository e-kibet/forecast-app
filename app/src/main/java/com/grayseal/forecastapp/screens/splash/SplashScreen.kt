package com.grayseal.forecastapp.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.grayseal.forecastapp.R
import com.grayseal.forecastapp.navigation.WeatherScreens
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = 1.5f, animationSpec = tween(durationMillis = 1000, easing = {
            OvershootInterpolator(4f).getInterpolation(it)
        }))
        delay(1000L)
        navController.navigate(route = WeatherScreens.WeatherScreen.name)
    })

    Surface() {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(colors.primary)
            .scale(scale.value),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.sunny_cloudy),
                contentDescription = "Splash Weather"
            )
        }
    }
}