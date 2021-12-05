package com.heptagon.heptagontaskappdemo.model

import com.google.gson.annotations.SerializedName
import com.heptagon.heptontaskappdemo.model.FormData


data class FormInfo (

  @SerializedName("status"    ) var status   : Boolean?  = null,
  @SerializedName("form_data" ) var formData : FormData? = FormData()

)