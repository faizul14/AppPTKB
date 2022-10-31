package com.example.appproductptkb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.GridLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appproductptkb.databinding.ActivityMainBinding
import com.example.appproductptkb.helper.ViewModelFactory
import com.example.appproductptkb.presentation.ui.ListAdapter
import com.example.appproductptkb.presentation.ui.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = ViewModelFactory.getIntance()
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        adapter = ListAdapter()

        binding.rvListProduct.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
        }
         loadData()
    }

    private fun loadData() {
        viewModel.product.observe(this){data->
            if (data != null){
                adapter.setData(data)
                binding.rvListProduct.adapter = adapter
            }
        }
    }
}