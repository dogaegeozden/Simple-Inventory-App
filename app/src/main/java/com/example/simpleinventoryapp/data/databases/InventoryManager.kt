package com.example.simpleinventoryapp.data.databases

import com.example.simpleinventoryapp.data.models.Item
import java.time.Instant
import java.util.Date


/**
 * InventoryManager is a simple in-memory database that provides basic CRUD (Create, Read, Update, Delete) operations for inventory items.
 */
object InventoryManager {

    private val itemList = mutableListOf<Item>()

    fun getAllItems() : List<Item>{
        return itemList
    }

    fun addItem(name: String, quantity: Int) {
        itemList.add(Item(System.currentTimeMillis().toInt(), name, quantity, Date.from(Instant.now())))
    }

    fun deleteItem(id: Int) {
        itemList.removeIf{
            it.id == id
        }
    }

    fun updateItem(id:Int, name:String, quantity: Int) {
        val index = itemList.indexOfFirst { it.id == id }
        if (index != -1) {
            itemList[index].name = name
            itemList[index].quantity = quantity
        }
    }
}