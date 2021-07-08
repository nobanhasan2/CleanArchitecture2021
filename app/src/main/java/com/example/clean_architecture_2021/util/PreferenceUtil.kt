package com.example.clean_architecture_2021.util

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.text.TextUtils
import com.example.clean_architecture_2021.AndroidApplication

class PreferenceUtil<T> {
    private val backedUpPreferences: SharedPreferences? = AndroidApplication().applicationContext.getSharedPreferences(BACKED_UP_NAME, MODE_PRIVATE)
    private val nonBackedUpPreferences: SharedPreferences? = AndroidApplication().applicationContext.getSharedPreferences(NON_BACKED_UP_NAME, MODE_PRIVATE)

    companion object {
        private const val BACKED_UP_NAME = "com.example.clean_architecture_2021.BACKED_UP"
        private const val NON_BACKED_UP_NAME = "com.example.clean_architecture_2021.NON_BACKED_UP"
    }
    fun  set(key: String, value: T, toBackedUp: Boolean = true): Boolean {
        val preferences = if (toBackedUp) backedUpPreferences else nonBackedUpPreferences
        if (preferences != null && !TextUtils.isEmpty(key)) {
            val editor = preferences.edit()
            when (value) {
                is String -> editor.putString(key, value)
                is Long -> editor.putLong(key, value)
                is Int -> editor.putInt(key, value)
                is Float -> editor.putFloat(key, value)
                is Boolean -> editor.putBoolean(key, value)
                else -> return false
            }
            return editor.commit()
        }
        return false
    }
}