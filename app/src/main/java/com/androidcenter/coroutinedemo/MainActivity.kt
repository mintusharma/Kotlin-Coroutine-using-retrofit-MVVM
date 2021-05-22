package com.androidcenter.coroutinedemo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.androidcenter.coroutinedemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var mainAdapter: MainAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getUserDataList().observe(this, Observer {
            if (it != null) {
                Log.d("TAG", "setupViewModel: ${it.items.size}")
                setupUI(it.items)
            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }

    // setup the UI
    private fun setupUI(userList: ArrayList<UserData>) {
        Log.d("TAG", "setupViewModel3: ${userList.size}")
        mainAdapter = MainAdapter(userList, this)
        Log.d("TAG", "MainAdapter Called")
        binding.progressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        binding.myAdapter = mainAdapter
    }
}
