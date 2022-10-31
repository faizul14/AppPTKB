package com.example.appproductptkb.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appproductptkb.data.network.response.DataItem
import com.example.appproductptkb.databinding.ItemProductBinding
import com.example.appproductptkb.helper.Discount
import com.example.appproductptkb.helper.FormatIDR

class ListAdapter() : RecyclerView.Adapter<ListAdapter.itemViewHolder>() {
    private val ListProduct = ArrayList<DataItem>()
    fun setData(data : List<DataItem>){
        ListProduct.clear()
        ListProduct.addAll(data)
    }
    class itemViewHolder (private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: DataItem){
            Glide.with(itemView.context)
                .load(data.thumbnailImage)
                .into(binding.imgListProduct)
            binding.apply {
                txtTittle.setText(data.title)
                txtPrice.setText(data.price?.let { FormatIDR.format(it) })
                txtDiscount.setText("${data.discount}%")
                txtPriceDiskon.setText(Discount.dc(data.price!!, data.discount!!))
                txtRc.setText(data.countRatingUser.toString())
                ratingBar.rating = data.productRating!!.toFloat()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val itemView = ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return itemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.bind(ListProduct[position])
    }

    override fun getItemCount(): Int = ListProduct.size
}