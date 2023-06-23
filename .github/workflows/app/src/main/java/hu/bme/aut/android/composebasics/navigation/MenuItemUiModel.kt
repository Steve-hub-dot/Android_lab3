package hu.bme.aut.android.composebasics.navigation

import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

enum class MenuItemUiModel(
    val text: @Composable () -> Unit,
    val icon: @Composable () -> Unit,
    val screenRoute: String
) {
    PROFILE(
        text = { Text(text = stringResource(id = hu.bme.aut.android.composebasics.R.string.dropdown_menu_item_label_profile))},
        icon = {
            Icon(imageVector = androidx.compose.material.icons.Icons.Default.Person, contentDescription = null)
        },
        screenRoute = Screen.Profile.route
    ),
    SETTINGS(
        text = { Text(text = stringResource(id = hu.bme.aut.android.composebasics.R.string.dropdown_menu_item_label_settings))},
        icon = {
            Icon(imageVector = androidx.compose.material.icons.Icons.Default.Settings, contentDescription = null)
        },
        screenRoute = Screen.Settings.route
    )
}