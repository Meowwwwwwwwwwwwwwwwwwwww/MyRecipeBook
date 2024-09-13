package com.example.myrecipebook

 sealed class Screen ( val route: String){
     object recipeScreen:Screen("recipescreen")
      object DetailScreen:Screen("detailscreen")
}