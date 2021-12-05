
package com.heptagon.heptagontaskappdemo.ui.main

import android.content.Context
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.heptagon.heptagontaskappdemo.R
import com.heptagon.heptagontaskappdemo.databinding.ItemFormBinding
import com.heptagon.heptagontaskappdemo.model.FieldType
import com.heptagon.heptagontaskappdemo.model.FormFields
import java.util.*
import com.heptagon.heptagontaskappdemo.utils.*

/**
 * [RecyclerView.ViewHolder] implementation to inflate View for RecyclerView.
 * See [FormAdapter]]
 */
class FormViewHolder(
    private val binding: ItemFormBinding,
    private val context: Context,
    private val activity: MainActivity
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(formFields: FormFields) {
        with(binding) {
            hideAllView()
            labelTv.text = formFields.label
            when (formFields.fieldType) {

                FieldType.LOGO.filedType -> {
                    showLogo()
                    SVGImageLoader.fetchSvg(context, formFields.textAns, image)
                }
                FieldType.EDITBOX.filedType -> {
                    if (formFields.key?.contains("date") == true) {
                        showCalenderView()
                    } else {
                        showEditText(formFields)
                    }

                }
                FieldType.DROPDOWN.filedType -> {
                    showSpinner(formFields)
                }
                FieldType.DATE.filedType -> {
                    showCalenderView()
                }
                FieldType.FILE.filedType -> {
                    showEditText(formFields)
                }
                FieldType.TEXTAREA.filedType -> {
                    showEditText(formFields)
                }
                else -> {
                    Log.d("extra field ", "${formFields.fieldType}")
                }
            }
        }
    }

    /**
     * Hide all view by default
     */
    private fun hideAllView() {
        with(binding) {
            image.hide()
            labelTv.hide()
            required.hide()
            formEtLayout.hide()
            spinnerView.hide()
            calenderView.hide()
        }
    }

    private fun showLogo() {
        with(binding) {
            image.show()
        }
    }

    /**
     * this method will show edit text
     */
    private fun showEditText(formFields: FormFields) {
        with(binding) {
            labelTv.show()
            required.show()
            formEtLayout.show()
            formEt.inputType = if (formFields.label?.contains("days") == true) {
                EditorInfo.TYPE_CLASS_NUMBER
            } else {
                EditorInfo.TYPE_CLASS_TEXT
            }
        }
    }

    /**
     * This method will show spinner for item selection and setup spinner item
     */
    private fun showSpinner(fromFields: FormFields) {
        with(binding) {
            labelTv.show()
            required.show()
            spinnerView.show()
            spinnerAutoComplete.setAdapter(getSpinnerListAdapter(fromFields))
            spinnerView.hint = fromFields.label
        }
    }


    /**
     * This method for show calender view for date selection
     */
    private fun showCalenderView() {
        with(binding) {
            labelTv.show()
            required.show()
            calenderView.show()
            calenderEt.transformIntoDatePicker(
                activity,
                "dd/MM/yyyy",
                Date()
            )
        }
    }

    private fun getSpinnerListAdapter(formFields: FormFields) = ArrayAdapter(
        activity,
        R.layout.spinner_item_layout,
        formFields.dropDownOption.map { it.viewText }
    )

}
