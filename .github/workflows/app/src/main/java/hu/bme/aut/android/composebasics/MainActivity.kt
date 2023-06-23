package hu.bme.aut.android.composebasics

import NormalTextView_Error_Preview
import NormalTextView_Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import hu.bme.aut.android.composebasics.feature.login.LoginScreen_Preview
import hu.bme.aut.android.composebasics.feature.register.RegisterScreen_Preview
import hu.bme.aut.android.composebasics.navigation.HomeScreen_Preview
import hu.bme.aut.android.composebasics.navigation.NavGraph
import hu.bme.aut.android.composebasics.navigation.ProfileScreen_Preview
import hu.bme.aut.android.composebasics.ui.common.TextButton_Preview
import hu.bme.aut.android.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                val navController =     rememberNavController()
                //NavGraph(navController = navController)
                ProfileScreen_Preview()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        Greeting("Android")
    }
}