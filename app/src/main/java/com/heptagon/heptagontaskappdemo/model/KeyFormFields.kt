package com.heptagon.heptagontaskappdemo.model

import com.google.gson.annotations.SerializedName
import com.heptagon.heptagontaskappdemo.model.FormFields


data class KeyFormFields (

  @SerializedName("key"         ) var key        : String?          = null,
  @SerializedName("form_fields" ) var formFields : List<FormFields> = arrayListOf()

)