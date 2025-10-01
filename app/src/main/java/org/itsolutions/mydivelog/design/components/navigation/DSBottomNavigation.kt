package org.itsolutions.mydivelog.design.components.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.theme.spacings.DS

@Serializable
data class DSBottomNavigationElement(
    val route: String,
    @StringRes val label: Int,
    @DrawableRes val icon: Int
)

@Composable
fun DSBottomNavigation(entries: List<DSBottomNavigationElement>) {
    val navController = rememberNavController()
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    val currentRoute = currentDestination?.hierarchy?.firstOrNull()?.route

    Column {
        HorizontalDivider(thickness = 1.dp)
        DSBottomNavigationBar(currentRoute, entries) {
            navController.navigateBackToHomepage(it)
        }
    }
}

@Composable
internal fun DSBottomNavigationBar(
    currentRoute: String?,
    entries: List<DSBottomNavigationElement>,
    onClick: (DSBottomNavigationElement) -> Unit,
) {
    NavigationBar {
        Row(
            modifier = Modifier.fillMaxWidth().padding(DS.spacing.sm),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            entries.forEach {
                NavigationBarItem(
                    selected = currentRoute == it.route,
                    onClick = { onClick(it) },
                    icon = {
                        Icon(
                            painter = painterResource(it.icon),
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }
}

private fun NavHostController.navigateBackToHomepage(route: DSBottomNavigationElement) {
    navigate(route.route) {
        popUpTo(graph.startDestinationId) {
            inclusive = false
        }
        launchSingleTop = true
    }
}

@Preview
@Composable
private fun DSBottomNavigationPreview() {
    DSBottomNavigationBar(
        currentRoute = "Two",
        entries = listOf(
            DSBottomNavigationElement(
                route = "One",
                label = R.string.app_name,
                icon = R.drawable.scuba_diving
            ),
            DSBottomNavigationElement(
                route = "Two",
                label = R.string.app_name,
                icon = R.drawable.emoji_people
            ),
            DSBottomNavigationElement(
                route = "Three",
                label = R.string.app_name,
                icon = R.drawable.scuba_diving
            ),
            DSBottomNavigationElement(
                route = "Four",
                label = R.string.app_name,
                icon = R.drawable.emoji_people
            ),
            DSBottomNavigationElement(
                route = "Five",
                label = R.string.app_name,
                icon = R.drawable.scuba_diving
            ),
        ),
        onClick = { }
    )
}