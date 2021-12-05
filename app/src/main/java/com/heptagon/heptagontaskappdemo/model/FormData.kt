package com.heptagon.heptontaskappdemo.model

import com.google.gson.annotations.SerializedName
import com.heptagon.heptagontaskappdemo.model.KeyFormFields


data class FormData (

  @SerializedName("key_form_fields" ) var keyFormFields : List<KeyFormFields> = arrayListOf()

)