package com.syntex_error.epbpos_kotlin.database

import androidx.room.*
import com.syntex_error.epbpos_kotlin.database.models.Items


@Dao
interface CartDao {

    @Query("SELECT * FROM item_table")
    fun getAll(): MutableList<Items>

    @Query("SELECT * FROM item_table WHERE item_id == :id LIMIT 1  ")
    suspend fun findByFoodId(id: String): Items?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItems(list: List<Items>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Items)


    @Delete
    fun delete(item: Items)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateItem(vararg item: Items)


}

interface ItemSelectInterface {
    fun itemSelect(id: String?, title: String?)
}