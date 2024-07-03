package com.example.movietmdb.utils.navigation

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable


@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = "home"){
        composable(route = "homeScreen"){
            HomeScreen(navController)
        }
        composable("loginScreen"){
            LoginScreen{
                navController.navigate(DataUnitRoute("",3))
            }
        }
        composable("RegisterScreen/{email}" , arguments = listOf(
            navArgument("email"){
                type = NavType.StringType
            }
        )){
            var args = it.toRoute<DataUnitRoute>()
            val email =it.arguments?.getString("email")
            RegisterScreen(email.toString())
        }
    }
}


@Serializable
data class DataUnitRoute(
    val name : String?,
    val id : Int?
)


@Composable
fun HomeScreen(navController: NavController) {
    Text(
        text = "homeScreen",
        modifier = Modifier.clickable { navController.navigate("home") }
    )
}

@Composable
fun LoginScreen(dataSend : (email : String)-> Unit){
    Text(text = "loginScreen" , modifier = Modifier.clickable {
        dataSend("praveen@gmail.com")
    })
}

@Composable
fun RegisterScreen(email : String){

    Text(text = email)
}