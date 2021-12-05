package com.heptagon.heptagontaskappdemo.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

/**
 * Abstract Activity which binds [ViewModel] [VM] and [ViewBinding] [VB]
 */
abstract class BaseActivity<VM : ViewModel, VB : ViewBinding> : AppCompatActivity() {

    protected abstract val viewModel: VM

    private var _binding: VB? = null
    protected val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = getViewBinding()
    }

    /**
     * It returns [VB] which is assigned to [viewBinding] and used in [onCreate]
     */
    protected abstract fun getViewBinding(): VB
}
