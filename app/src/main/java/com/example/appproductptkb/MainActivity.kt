package com.example.appproductptkb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.GridLayout
import android.widget.Toast
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu1->{
                Toast.makeText(this, "cart", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu2->{
                Toast.makeText(this, "notifikasi", Toast.LENGTH_SHORT).show()
                return true
            }else -> return true
        }
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