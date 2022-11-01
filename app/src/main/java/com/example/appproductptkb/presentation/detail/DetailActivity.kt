package com.example.appproductptkb.presentation.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.appproductptkb.R
import com.example.appproductptkb.data.network.response.CommentItem
import com.example.appproductptkb.data.network.response.Data
import com.example.appproductptkb.databinding.ActivityDetailBinding
import com.example.appproductptkb.helper.Discount
import com.example.appproductptkb.helper.FormatIDR
import com.example.appproductptkb.helper.ViewModelFactory

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    private lateinit var adapter : KomenAdapter
    lateinit var viewPagerAdapter: viewpagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val factory = ViewModelFactory.getIntance()
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        adapter = KomenAdapter()
        binding.rvKomen.apply {
            layoutManager = LinearLayoutManager(this@DetailActivity)
            setHasFixedSize(true)
        }

        val data_id = intent.getStringExtra(DATA_ID)
        binding.apply {
            nstd.visibility = View.GONE
            cardView2.visibility = View.GONE
            prgBar.visibility = View.VISIBLE
        }

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
            txtKomentar.setText(resources.getString(R.string.komentar, data.comment?.size ?: 0))
            txtDiscount.setText("${data.discount}%")
            txtPrice.setText(data.price?.let { FormatIDR.format(it) })
            txtPriceDiskon.setText(data.price?.let { data.discount?.let { it1 ->
                Discount.dc(it,
                    it1
                )
            } })

            viewPagerAdapter = viewpagerAdapter(application, data.imageSlide)
            binding.imageView.adapter = viewPagerAdapter
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

    override fun onResume() {
        super.onResume()
    }


    private fun loadKoment(data: List<CommentItem>) {
       if (data != null ){
           val notFull = ArrayList<CommentItem>()
           if (data.size > 2){
               notFull.clear()
               for (i in 0..2){
                   notFull.addAll(listOf(data[i]))
               }
               adapter.setData(notFull)
               binding.rvKomen.adapter = adapter
           }
           binding.txtSelengkapnya.setOnClickListener {
               adapter.setData(data)
               binding.rvKomen.adapter = adapter
               binding.txtSelengkapnya.visibility = View.GONE
               binding.txtLebihsedikit.visibility = View.VISIBLE
           }
           binding.txtLebihsedikit.setOnClickListener {
               adapter.setData(notFull)
               binding.rvKomen.adapter = adapter
               binding.txtSelengkapnya.visibility = View.VISIBLE
               binding.txtLebihsedikit.visibility = View.GONE
           }
       }
    }

    companion object{
        const val DATA_ID ="data_id"
    }

}