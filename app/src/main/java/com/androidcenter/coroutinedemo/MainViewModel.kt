package com.androidcenter.coroutinedemo

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {
    private var userLiveData:MutableLiveData<User> = MutableLiveData()

    fun getUserDataList():MutableLiveData<User>{
        return userLiveData
    }

    // api call using Kotlin coroutine
    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.Main){
            val retrofitInstance=RetrofitBuilder.getRetrofit().create(ApiService::class.java)
            val apiResponse=retrofitInstance.getUsers("in")
            Log.d("TAG", "makeApiCall : $apiResponse")
            userLiveData.postValue(apiResponse)
        }
    }
    // binding adapter for image loading from url using glide
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(imageView: ImageView, imageUrl: String?) {
            Glide.with(imageView.context).load(imageUrl).apply(RequestOptions.circleCropTransform())
                .into(imageView)
        }
    }
}

