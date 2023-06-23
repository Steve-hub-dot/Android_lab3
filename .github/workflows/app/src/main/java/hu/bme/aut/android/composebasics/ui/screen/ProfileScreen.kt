package hu.bme.aut.android.composebasics.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hu.bme.aut.android.composebasics.R

@ExperimentalMaterial3Api
@Composable
fun ProfileScreen(
    argument: String,
    modifier: Modifier = Modifier
) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "$argument", fontWeight = FontWeight.Bold)
            }
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier
                            .width(150.dp)
                            .border(width = 1.dp, color = Color.Black),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_prof_foreground),
                            contentDescription = "Profile picture",
                            modifier = Modifier.clip(
                                RectangleShape
                            )
                        )
                    }
                }
            }
        }
    }

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ProfileScreen_Preview() {
    ProfileScreen(
        argument = "Karsai_Istvan",
    )
}