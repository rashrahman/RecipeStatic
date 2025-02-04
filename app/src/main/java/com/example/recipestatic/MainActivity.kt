package com.example.recipestatic

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipestatic.ui.theme.RecipeStaticTheme

import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.VerticalDivider
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

data class Recipe(
    val image: Int,
    val title: String,
    val ingredients: List<String>,
    val directions: String,
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeStaticTheme {
                    val kacchiRecipe= Recipe(
                    image = R.drawable.kacchi,
                    title = "Kacchi Biriyani",
                        ingredients = listOf("4.5 lbs of mutton",
                            "4.5 lbs of basmati rice",
                            "1 cup plain yogurt",
                            "1 cup ghee",
                            "4-5 large white onions",
                            "1/2 cup fried onions (topping)",
                            "5 green chillies",
                            "10-12 green cardamom pods, 8-10 cloves, 4-5 cinnamon sticks, 3-4 bay leaves, 2-3 star anise",
                            "3 tbsp ginger paste, 3 tbsp garlic paste, 2 tbsp salt, 2 tsp red chili powder, 1 tsp white pepper powder",
                            "Saffron strands"
                            ),
                        directions = "Meat Marination (4-6 hours):\n" +
                                "- Mix mutton with yogurt, spices, and aromatics\n" +
                                "- Let marinate at room temperature\n" +

                                "- Wash Basmati rice\n" +
                                "- Par-boil with whole spices\n" +
                                "- Drain when 70% cooked\n" +

                                "- Layer marinated meat at bottom\n" +
                                "- Spread par-boiled rice evenly\n" +
                                "- Sprinkle fried onions, herbs, saffron milk\n" +
                                "- Drizzle generously with ghee\n" +

                                "- Seal pot with tight lid\n" +
                                "- Cook on very low heat (1.5-2 hours)\n" +

                                "- Rest for 15-20 minutes\n" +
                                "- Gently mix layers\n" +
                                "- Garnish with fried onions and nuts"
                    )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                    {
                        RecipeCard(recipe = kacchiRecipe)
                    }

            }
        }
    }
}


@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = Color.Gray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            // Image Section on top
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = recipe.image),
                    contentDescription = recipe.title,
                    modifier = Modifier
                        .fillMaxSize(),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                )
            }

            // Title
            Text(
                text = recipe.title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            // Divider between title and text
            HorizontalDivider(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(1.dp)
            )

            // Ingredients and Directions Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Ingredients Column
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Ingredients",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    recipe.ingredients.forEach { ingredient ->
                        Text(
                            text = "• $ingredient",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(vertical = 2.dp)
                        )
                    }
                }

                // Vertical Divider between ingredients and steps section
                VerticalDivider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp)
                )

                // Directions Column
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Directions",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = recipe.directions,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}



