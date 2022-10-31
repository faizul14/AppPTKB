package com.example.appproductptkb.presentation.detail

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appproductptkb.data.network.response.CommentItem
import com.example.appproductptkb.data.network.response.DataItem
import com.example.appproductptkb.data.network.response.ResponseDetail
import com.example.appproductptkb.databinding.ItemKomenBinding
import com.example.appproductptkb.databinding.ItemProductBinding
import com.example.appproductptkb.helper.Discount
import com.example.appproductptkb.helper.FormatIDR
import com.example.appproductptkb.presentation.detail.DetailActivity

class KomenAdapter() : RecyclerView.Adapter<KomenAdapter.itemViewHolder>() {
    private val ListKoment = ArrayList<CommentItem>()
    fun setData(data : List<CommentItem>){
        ListKoment.clear()
        ListKoment.addAll(data)
    }
    class itemViewHolder (private val binding: ItemKomenBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: CommentItem){
            binding.apply {
                ratingBar2.rating = data.rating!!.toFloat()
                txtNameKoment.setText(data.name)
                deskripsiKomen.setText(data.comment)
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(imgKomen)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val itemView = ItemKomenBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return itemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.bind(ListKoment[position])
    }

    override fun getItemCount(): Int = ListKoment.size
}