package com.alezzgo.socialmedia.ui.components

import androidx.annotation.StringRes
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alezzgo.socialmedia.R
import com.alezzgo.socialmedia.ui.screens.destinations.*
import com.alezzgo.maps.destinations.*
import com.alezzgo.socialmedia.ui.screens.destinations.Destination

@NonRestartableComposable
@Composable
fun MainBottomAppBar(
    navController: NavController,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Home,
        BottomNavItem.Workshop,
        BottomNavItem.Settings,
//        BottomNavItem.Maps,
    ),
) = BottomAppBar {
    items.forEach {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        NavigationBarItem(
            selected = currentDestination?.route?.contains(it.destination.route) == true,
            alwaysShowLabel = true,
            onClick = {
                navController.navigate(it.destination.route) {
                    navController.graph.startDestinationRoute?.let { screen_route ->
                        popUpTo(screen_route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(it.icon),
                    contentDescription = null
                )
            },
            label = {
                Text(
                    modifier = Modifier,
                    text = stringResource(it.title)
                )
            }
        )
    }

}


sealed class BottomNavItem(@StringRes val title: Int, val icon: Int, val destination: Destination) {
    object Home : BottomNavItem(
        title = R.string.main,
        icon = R.drawable.ic_home,
        destination = HomeScreenDestination
    )

    object Workshop : BottomNavItem(
        title = R.string.workshop,
        icon = R.drawable.ic_basket,
        destination = WorkshopScreenDestination
    )

    object Settings : BottomNavItem(
        title = R.string.settings,
        icon = R.drawable.ic_settings,
        destination = SettingsScreenDestination
    )

//    object Maps : BottomNavItem(
//        title = R.string.maps,
//        icon = R.drawable.ic_maps,
//        destination = MapsScreenDestination
//    )
}
