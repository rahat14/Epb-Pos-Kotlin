package com.syntex_error.epbpos_kotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.syntex_error.epbpos_kotlin.Items_edit_adpater
import com.syntex_error.epbpos_kotlin.database.OfflineDatabase
import com.syntex_error.epbpos_kotlin.database.models.Items
import com.syntex_error.epbpos_kotlin.databinding.ActivityProductSearchBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductSearch : AppCompatActivity(), Items_edit_adpater.Interaction {
    private lateinit var localDb: OfflineDatabase
    private lateinit var mAdapter: Items_edit_adpater
    private var nameList: List<String> = mutableListOf(
        "test",
        "xyz",
        "rr",
        "pokemon",
        "2test",
        "Pen",
        "Drive",
        "pencil",
        "orange",
        "pro-test"
    )
    private lateinit var binding: ActivityProductSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        localDb = OfflineDatabase(applicationContext)
        mAdapter = Items_edit_adpater(this)
        loadItems()

        binding.products.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }

    }

    private fun loadItems() {
        CoroutineScope(Dispatchers.IO).launch {
            val list = localDb.cartDao().getAll()
            if (list.isEmpty()) {
                createDemoProduct()
            } else {
                withContext(Dispatchers.Main) {
                    mAdapter.submitList(list)
                }
            }
        }
    }


    private fun createDemoProduct() {
        val list: MutableList<Items> = mutableListOf()
        for (i in 0..9) {
            val model = Items()
            model.name = nameList[i]
            list.add(model)
        }
        CoroutineScope(Dispatchers.IO).launch {
            localDb.cartDao().insertItems(list)
        }

        loadItems()
    }

    override fun onItemSelected(position: Int, item: Items) {

    }
}