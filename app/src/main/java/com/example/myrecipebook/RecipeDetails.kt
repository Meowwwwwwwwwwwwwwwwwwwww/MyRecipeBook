package com.example.myrecipebook

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeDetails(category:Categories) {

    Column(modifier= Modifier
        .fillMaxSize()
        .padding(8.dp),
        ) {
           Text(text = category.strCategory, textAlign = TextAlign.Center)
        
        Image(painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription =null,
             modifier=Modifier.wrapContentSize().aspectRatio(1f)
            )
        
        Text(text = category.strCategoryDescription,
            modifier=Modifier.verticalScroll(
            rememberScrollState()),
            textAlign = TextAlign.Justify)
        
        
        
    }

}
