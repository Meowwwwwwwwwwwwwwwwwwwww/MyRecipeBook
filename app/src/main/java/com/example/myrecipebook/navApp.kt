package com.example.myrecipebook

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController

@Composable
fun navApp(){
    val viewModelScreen:ViewModelMain= viewModel()  //object creation
    val viewstate by viewModelScreen.categoriesState
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = Screen.recipeScreen.route){
           composable(route= Screen.recipeScreen.route){
                        RecipeScreen(viewstate=viewstate, navtoRecipeDetail = {
                            nav.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                            nav.navigate(Screen.DetailScreen.route)
                        } )
 }
         composable( route=Screen.DetailScreen.route){
              val category= nav.previousBackStackEntry?.savedStateHandle?.get<Categories>("cat")?: Categories("","","","")
               RecipeDetails(category = category)
        }
    }

}

