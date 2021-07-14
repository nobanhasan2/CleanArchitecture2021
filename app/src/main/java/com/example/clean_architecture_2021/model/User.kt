package com.example.clean_architecture_2021.model

import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("Id")
    var id = 0

    @SerializedName("Name")
    var name: String? = null

    @SerializedName("Email")
    var email: String? = null

    @SerializedName("Phone")
    var phone: String? = null

    @SerializedName("AccessToken")
    var accessToken: String? = null

    @SerializedName("Photo")
    var photo: String? = null
}