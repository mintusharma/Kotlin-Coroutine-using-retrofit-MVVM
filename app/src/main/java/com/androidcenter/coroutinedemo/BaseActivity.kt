package com.androidcenter.coroutinedemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


open class BaseActivity:AppCompatActivity() {

   /* private lateinit var disposable: CompositeDisposable
    private lateinit var retrofitBuilder: RetrofitBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retrofitBuilder = RetrofitBuilder()
        disposable = CompositeDisposable()
    }

    fun getRetrofit(): RetrofitBuilder {
        return retrofitBuilder
    }



    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    open fun onInternetUnavailable() {
        showSnackBar("No Internet")
    }

    private fun showSnackBar(message: String?) {
        getView()?.let { Snackbar.make(it, message!!, Snackbar.LENGTH_SHORT).show() }
    }

    private fun getView(): View? {
        return findViewById(R.id.content)
    }*/
}