package com.heptagon.heptagontaskappdemo.ui.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heptagon.heptagontaskappdemo.databinding.ItemFormBinding
import com.heptagon.heptagontaskappdemo.model.FormFields

/**
 * Adapter class [RecyclerView.Adapter] for [RecyclerView] which binds [FormFields] along with [FormViewHolder]
 *
 */
class FormAdapter(private val context: Context,private val activity: MainActivity) : RecyclerView.Adapter<FormViewHolder>() {

    private val formFields = ArrayList<FormFields>()

    fun setItems(items: ArrayList<FormFields>) {
        Log.e("FormAdapter",items.toString())
        this.formFields.clear()
        this.formFields.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FormViewHolder(
        ItemFormBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),context,activity
    )

    override fun onBindViewHolder(holder: FormViewHolder, position: Int) =
        holder.bind(formFields[position])

    override fun getItemCount() = formFields.size


}