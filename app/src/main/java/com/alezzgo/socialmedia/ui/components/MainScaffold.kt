import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.alezzgo.socialmedia.ui.components.BottomNavItem
import com.alezzgo.socialmedia.ui.components.MainBottomAppBar

@Composable
fun MainScaffold(
    navController: NavController,
    showBottomBar: Boolean = true,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Home,
        BottomNavItem.Workshop,
        BottomNavItem.Settings,
        BottomNavItem.Maps,
    ),
    content: @Composable (paddingValues: PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                MainBottomAppBar(navController, items)
            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}