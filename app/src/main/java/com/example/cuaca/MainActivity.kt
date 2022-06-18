package com.example.cuaca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cuaca.model.RegionModel
import com.example.cuaca.ui.MainScreen
import com.example.cuaca.ui.detail.DetailScreen
import com.example.cuaca.ui.theme.TestProdiaTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestProdiaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // A surface container using the 'background' color from the theme
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "list_region")
                    {
                        composable("list_region") {
                            MainScreen { region, enableSave->
                                val data = Gson().toJson(region, RegionModel::class.java)
                                navController.navigate("detail/${data}/${enableSave}")
                            }
                        }
                        composable("detail/{region}/{enableSave}", arguments = listOf(
                            navArgument("region") {
                                type = NavType.StringType
                            },
                            navArgument("enableSave") {
                                type = NavType.BoolType
                            }
                        )) {
                            val json = it.arguments?.getString("region") ?: ""
                            val enableSave = it.arguments?.getBoolean("enableSave")?:false
                            val region = Gson().fromJson(json, RegionModel::class.java)
                            DetailScreen(region = region,enableSave)
                        }
                    }

                }
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
    TestProdiaTheme {
        Greeting("Android")
    }
}