package com.example.clean_architecture_2021.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.text.TextUtils
import javax.inject.Inject
import javax.inject.Singleton

class PreferenceUtil<T> {
    companion object{

        const val NON_BACKED_UP_NAME = "com.example.clean_architecture_2021.NON_BACKED_UP"
    }

    @Inject
    lateinit var preferences: SharedPreferences

    fun  set(key: String, value: T): Boolean {
        if (!TextUtils.isEmpty(key)) {
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
     fun  get(key: String, defaultValue : T): T {
        when(defaultValue) {
            is Boolean -> return preferences.getBoolean(key, defaultValue as Boolean) as T
            is Float -> return preferences.getFloat(key, defaultValue as Float) as T
            is Int -> return preferences.getInt(key, defaultValue as Int) as T
            is Long -> return preferences.getLong(key, defaultValue as Long) as T
            is String -> return preferences.getString(key, defaultValue as String) as T
            else -> {
                if (defaultValue is Set<*>) {
                    return preferences!!.getStringSet(key, defaultValue as Set<String>) as T
                }
            }
        }

        return defaultValue
    }
}