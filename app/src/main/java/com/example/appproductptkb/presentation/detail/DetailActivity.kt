package com.example.appproductptkb.presentation.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.appproductptkb.R
import com.example.appproductptkb.data.network.response.CommentItem
import com.example.appproductptkb.data.network.response.Data
import com.example.appproductptkb.databinding.ActivityDetailBinding
import com.example.appproductptkb.helper.ViewModelFactory

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    private lateinit var adapter : KomenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getIntance()
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        adapter = KomenAdapter()
        binding.rvKomen.apply {
            layoutManager = LinearLayoutManager(this@DetailActivity)
            setHasFixedSize(true)
        }

        val data_id = intent.getStringExtra(DATA_ID)

        if (data_id != null){
            loadData(data_id)
        }
    }

    private fun loadData(id: String) {
       viewModel.getData(id).observe(this){data->
           if (data != null){
               data.data?.let { renderView(it) }
               data.error?.let { getLoading(it) }
           }
       }
    }

    @SuppressLint("StringFormatMatches")
    private fun renderView(data: Data){
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(data.imageSlide)
            ratingBar.rating = data.productRating!!.toFloat()
            txtRc.setText(resources.getString(R.string.rc_rating, data.countRatingUser))
            txtSeler.setText(data.sellerName)
            txtTittle.setText(data.title)
            txtContentDesc.setText(data.descProduct)

        }

        loadKoment(data.comment as List<CommentItem>)
    }

    fun getLoading(status: Boolean){
        if (!status){
            binding.apply {
                nstd.visibility = View.VISIBLE
                cardView2.visibility = View.VISIBLE
                prgBar.visibility = View.GONE
            }
        }else{
            binding.apply {
                nstd.visibility = View.GONE
                cardView2.visibility = View.GONE
                prgBar.visibility = View.VISIBLE
            }
        }
    }



    private fun loadKoment(data: List<CommentItem>) {

                adapter.setData(data)
                binding.rvKomen.adapter = adapter

    }

    companion object{
        const val DATA_ID ="data_id"
    }

}