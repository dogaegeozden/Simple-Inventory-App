package com.example.simpleinventoryapp.data.models

import java.util.Date


/**
 * A data class to represent the item in the inventory
 */
data class Item(

    var id: Int,
    var name: String,
    var quantity: Int,
    var createdAt: Date,
)