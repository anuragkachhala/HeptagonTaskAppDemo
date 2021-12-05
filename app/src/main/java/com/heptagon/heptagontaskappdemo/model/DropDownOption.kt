package com.heptagon.heptagontaskappdemo.model

import com.google.gson.annotations.SerializedName

data class DropDownOption (
    @SerializedName("id") var id: Int? = null,
    @SerializedName("view_text") var viewText: String? = null
)

