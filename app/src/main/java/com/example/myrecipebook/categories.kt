package com.example.myrecipebook

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
 data class Categories (val idCategory: String,
                        val strCategory:String,
                        val strCategoryThumb:String,
                        val strCategoryDescription: String) :Parcelable


 data class CategoryResponse(val categories:List<Categories>)


