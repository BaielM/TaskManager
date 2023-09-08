package com.example.taskmanager.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    fun isShowed(): Boolean{
        return pref.getBoolean(SHOWED_KEY, false)
    }
    fun onBoardingShow(){
        pref.edit().putBoolean(SHOWED_KEY, true).apply()
    }
    fun saveName(name:String){
        pref.edit().putString(NAME_KEY, name).apply()
    }

    fun getName():String?{
        return pref.getString(NAME_KEY, "")
    }

    fun saveImage(image: String){
        pref.edit().putString(IMAGE_KEY, image).apply()
    }

    fun getImage(): String?{
        return pref.getString(IMAGE_KEY, "")
    }

    companion object{
        const val SHOWED_KEY = "showed.key"
        const val PREF_NAME = "task.manager.pref"
        const val NAME_KEY = "name.key"
        const val IMAGE_KEY = "image.key"
    }
}