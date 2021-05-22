package com.androidcenter.coroutinedemo

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.androidcenter.coroutinedemo.databinding.UserItemBinding

class MainAdapter(private val users: ArrayList<UserData>, private val context: Context) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    private var layoutInflater: LayoutInflater? = null

    inner class DataViewHolder(private val myListBinding: UserItemBinding) :
        RecyclerView.ViewHolder(myListBinding.root) {
        fun bind(myList: UserData) {
            myListBinding.userData = myList
            myListBinding.itemContainer.setOnClickListener {
                onItemClick(myList.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val myListBinding: UserItemBinding =
            DataBindingUtil.inflate(layoutInflater!!, R.layout.user_item, parent, false)
        return DataViewHolder(myListBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val myListViewModel = users[position]
        holder.bind(myListViewModel)
    }

    fun onItemClick(username: String){
        Toast.makeText(context,"Hi , $username", Toast.LENGTH_SHORT).show()
    }
    override fun getItemCount(): Int {
        Log.d("TAG", "getItemCount: ${users.size}")
        return users.size
    }
}