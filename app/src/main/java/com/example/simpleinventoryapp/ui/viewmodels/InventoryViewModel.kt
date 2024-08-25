package com.example.simpleinventoryapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleinventoryapp.data.databases.InventoryManager
import com.example.simpleinventoryapp.data.databases.InventoryManager.deleteItem
import com.example.simpleinventoryapp.data.databases.InventoryManager.getAllItems
import com.example.simpleinventoryapp.data.models.Item

/**
 * This InventoryViewModel class acts as an intermediary between the UI and data storage, exposing a list of inventory items through LiveData, and providing methods to add, delete, update and retrieve inventory items, while also updating the UI accordingly.
 */
class InventoryViewModel : ViewModel() {

    // LiveData objects can be observed by the other parts of the application, typically a UI
    private var _itemList = MutableLiveData<List<Item>>()
    val itemList : LiveData<List<Item>> = _itemList

    init {
        getAllItems()
    }

    fun getAllItems() {
        _itemList.value = InventoryManager.getAllItems().reversed()
    }

    fun addItem(name: String, quantity: Int) {
        InventoryManager.addItem(name, quantity)
        getAllItems()
    }

    fun deleteItem(id: Int){
        InventoryManager.deleteItem(id)
        getAllItems()
    }

    fun updateItem(id: Int, name: String, quantity: Int) {
        InventoryManager.updateItem(id, name, quantity)
        getAllItems()
    }

}