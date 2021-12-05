package com.heptagon.heptagontaskappdemo.model

import com.google.gson.annotations.SerializedName
import com.heptagon.heptagontaskappdemo.model.DropDownOption


data class FormFields(

    @SerializedName("label") var label: String? = null,
    @SerializedName("text_ans") var textAns: String? = null,
    @SerializedName("required") var required: Int? = null,
    @SerializedName("key") var key: String? = null,
    @SerializedName("field_type") var fieldType: String? = null,
    @SerializedName("edit_flag") var editFlag: Int? = null,
    @SerializedName("drop_down_options") var dropDownOption: List<DropDownOption> = arrayListOf(),
    @SerializedName("key_flag") var keyFlag: Int? = null

)


