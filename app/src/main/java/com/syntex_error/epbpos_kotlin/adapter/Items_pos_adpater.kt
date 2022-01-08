package com.syntex_error.epbpos_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.syntex_error.epbpos_kotlin.R
import com.syntex_error.epbpos_kotlin.database.models.Items
import com.syntex_error.epbpos_kotlin.databinding.ItemPosProductBinding
import com.syntex_error.epbpos_kotlin.databinding.ItemProductHorizontralBinding

class Items_pos_adpater(
    private val interaction: Interaction? = null
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Items>() {

        override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem.local_db_id == newItem.local_db_id
        }

        override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return itemViewholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_pos_product,
                parent,
                false
            ),
            interaction
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is itemViewholder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Items>) {
        differ.submitList(ArrayList(list))
    }

    class itemViewholder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Items) {
            val binding = ItemPosProductBinding.bind(itemView)

            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }

            binding.name.text = item.name
            binding.code.text = "${item.custom_code}"
            binding.qty.text = "${item.qty} PCS"


        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Items)
    }
}
