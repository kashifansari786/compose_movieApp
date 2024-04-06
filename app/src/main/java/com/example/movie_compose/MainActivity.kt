package com.example.movie_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.movie_compose.data.ProjectData
import com.example.movie_compose.navigation.MovieNavigation
import com.example.movie_compose.ui.theme.BankUi_composeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankUi_composeTheme {
                setBarColor(color = MaterialTheme.colorScheme.background)
                // A surface container using the 'background' color from the theme
                //tipCalculator()
                val navController= rememberNavController()
                MovieNavigation(navController)
                //MovieListScreen()
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                   // Greeting("Android")
//                    portfolio()
//                   // HomeScreen()
//                }
            }
        }
    }
}




fun getProjectList():List<ProjectData>{
    return listOf(
        ProjectData(name = "Social Media App", desc = "Connect with your friends"),
        ProjectData(name = "Media player App", desc = "Listen music ecdlessyly"),
        ProjectData(name = "Social Medial App1", desc = "Connect with your friends1"),
        ProjectData(name = "Social Medial App2", desc = "Connect with your friends2"),
        ProjectData(name = "Social Medial App3", desc = "Connect with your friends3"),
    )
}




@Composable
private fun setBarColor(color:Color){
    val systemUiController= rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = color
        )
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Preview
//@Composable
//fun HomeScreen(){
//    Scaffold(bottomBar = {
//        BottomNavigationBar()
//    }) {padding->
//        Column(modifier = Modifier
//            .fillMaxSize()
//            .padding(padding)) {
//
//        }
//        //WalletSection()
//        //CardSection()
//        Spacer(modifier = Modifier.height(16.dp))
//        //FinanceSection()
//        //CurrenciesSection()
//    }
//}
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BankUi_composeTheme {
//        Greeting("Android")
//    }
//}