import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.alezzgo.socialmedia.ui.components.BottomNavItem
import com.alezzgo.socialmedia.ui.components.SocialMediaBottomAppBar

@Composable
fun CustomScaffold(
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
                SocialMediaBottomAppBar(navController,items)
            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}