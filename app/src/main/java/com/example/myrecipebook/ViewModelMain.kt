package com.example.myrecipebook

import android.icu.util.ULocale.Category
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

     class ViewModelMain :ViewModel ( ){
         private val _categoryState = mutableStateOf(RecipeState())
         val categoriesState: State<RecipeState> = _categoryState
         init {
             fetch()
         }

  private fun fetch(){
      viewModelScope.launch {
     try{
           val response= recipeService.getCategories()
         _categoryState.value =_categoryState.value.copy(
             error=null,
             loading = false,
             lists =response.categories
         )

     }catch (e:Exception){
         _categoryState.value =_categoryState.value.copy(

             error = "oops ${e.message}",
             loading = false,

         )

     }}}

      data class RecipeState(
          val error: String? = null,
          val loading: Boolean = false,
          val lists :List<Categories> = emptyList()
      )
}
