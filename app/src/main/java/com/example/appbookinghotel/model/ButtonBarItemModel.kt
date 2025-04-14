package com.example.appbookinghotel.model

import com.example.appbookinghotel.databinding.EditButtonBarItemBinding

data class ButtonBarItemModel(
    val binding : EditButtonBarItemBinding,
    val iconRes : Int,
    val text : String,
    val position : Int
)
