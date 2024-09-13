package com.example.myrecipebook

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


@Composable
fun RecipeScreen(modifier: Modifier =Modifier,
                 navtoRecipeDetail: (Categories) -> Unit,
                 viewstate: ViewModelMain.RecipeState){


    Box(modifier=Modifier.fillMaxSize()){
    when{
         viewstate.loading->{
             CircularProgressIndicator(Modifier.align(Alignment.Center))
         }
        viewstate.error!=null -> {
           Text(text ="oops error occured try later")
        }
        else->{
           CategoryScreen(categories = viewstate.lists,navtoRecipeDetail)

        }
    }


    }
}
@Composable
fun CategoryScreen(categories: List<Categories>, navtoRecipeDetail: (Categories) -> Unit ){
    LazyVerticalGrid(GridCells.Fixed(2),Modifier.fillMaxSize() ){
        items(categories){
            category->
            CategoriesItems(category = category,navtoRecipeDetail)
        }

    }

}
@Composable
fun CategoriesItems(category:Categories,navtoRecipeDetail:(Categories)->Unit){
    Column( modifier=Modifier
        .fillMaxSize()
        .aspectRatio(1f)
        .clickable { navtoRecipeDetail(category) }){
        Text(text =category.strCategory,
            modifier=Modifier.padding(top = 4.dp),
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
        
        Image(painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription =null,
            modifier= Modifier
                .fillMaxSize()
                .aspectRatio(1f)
            )
        
    }
}