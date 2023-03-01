package com.example.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.model.HeroesRepository.heroes
import com.example.superheroesapp.ui.theme.SuperHeroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesAppTheme {
                // A surface container using the 'background' color from the theme
                HeroesApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesApp() {
    Scaffold(
        topBar = {
            TopBar()
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        HeroesList(heroes = heroes, modifier = Modifier.padding(it))
    }
}

@Composable
private fun TopBar() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .size(56.dp)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.displayMedium
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun HeroesList(
    heroes: List<Hero>,
    modifier: Modifier
) {
    // make animation for list
    val visibleState = remember {
        MutableTransitionState(true).apply {
            targetState = true
        }
    }

    // fade in animation for entire list
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessLow
            )
        ),
        exit = fadeOut()
    ) {
        LazyColumn(
            modifier = modifier.padding(16.dp, 8.dp)
        ) {
            items(heroes) { hero ->
                SuperHeroItem(
                    hero = hero
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperHeroesAppTheme {
        HeroesApp()
    }
}