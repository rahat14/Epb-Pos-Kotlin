package com.syntex_error.epbpos_kotlin.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Items(
    @PrimaryKey(autoGenerate = true)
    var local_db_id: Int = 0,
    var item_id: Int = 0,
    var custom_code: String = "",
    var name: String = "",
    var type_id: Int = 0,
    var category_id: Int = 0,
    var dealer_price: Double = 0.0,
    var sale_price: Double = 0.0,
    var brand_id: Int = 0,
    var brand: String = "",
    var color: String = "",
    var size: String = "",
    var waight: String = "",
    var material: String = "",
    var alert_quantity: Double = 0.0,
    var vat_id: Int = 0,
    var unit_id: Int = 0,
    var user_id: Int = 0,
    var expiry_date: String = "",
    var company_id: Int = 0,
    var available_for_subscription: String = "",
    var featured_item: String = "",
    var pc_original_thumb: String = "",
    var pc_mobile_thumb: String = "",
    var pc_teb_thumb: String = "",
    var pc_desktop_thumb: String = "",
    var perishable_status: String = "",
    var perishable_days: String = "",
    var production_item: String = "",
    var del_status: String = "",
    var status: String = "",
    var row_updated: String = "",
    var description: String = "",

    var qty: Int = 0,
    )