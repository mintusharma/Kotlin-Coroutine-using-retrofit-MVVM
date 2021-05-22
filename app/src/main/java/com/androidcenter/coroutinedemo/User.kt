package com.androidcenter.coroutinedemo

data class User(val items:ArrayList<UserData>)
data class UserData(val name:String,val description:String, val owner:Owner)
data class Owner(val avatar_url:String)