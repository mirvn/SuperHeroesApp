package com.example.superheroesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.model.HeroesRepository
import com.example.superheroesapp.ui.theme.SuperHeroesAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(16.dp, 8.dp),
        elevation = CardDefaults.cardElevation
            (defaultElevation = 4.dp)
    ) {
        Row(
            modifier = modifier
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(
                modifier = modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall,
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))

            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Composable
@Preview()
fun preview() {
    SuperHeroesAppTheme {
        SuperHeroItem(hero = HeroesRepository.heroes[1], modifier = Modifier)
    }
}