package com.heptagon.heptagontaskappdemo.ui.main

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.heptagon.heptagontaskappdemo.R
import com.heptagon.heptagontaskappdemo.databinding.ActivityMainBinding
import com.heptagon.heptagontaskappdemo.model.FormFields
import com.heptagon.heptagontaskappdemo.ui.base.BaseActivity
import com.heptagon.heptagontaskappdemo.utils.ActivityUtils.getColorRes
import com.heptagon.heptagontaskappdemo.utils.ActivityUtils.showToast
import com.heptagon.heptagontaskappdemo.utils.NetworkUtils
import com.heptagon.heptagontaskappdemo.utils.Resource
import com.heptagon.heptagontaskappdemo.utils.hide
import com.heptagon.heptagontaskappdemo.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModels()

    private lateinit var adapter: FormAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        handleNetworkChanges()
        initView()

    }

    private fun initView() {
        binding.run {
            adapter = FormAdapter(applicationContext, this@MainActivity)
            formRecyclerView.adapter = adapter
            formRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
            swipeRefreshLayout.setOnRefreshListener { setUpFormDataObserver() }
        }
    }

    private fun setUpFormDataObserver() {
        viewModel.getFromInfo().observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        showLoading(false)
                        showAllViews()
                        adapter.setItems(resource.data?.formData?.keyFormFields?.get(0)?.formFields as ArrayList<FormFields>)

                    }
                    Resource.Status.ERROR -> {
                        showAllViews()
                        showLoading(false)
                        it.message?.let { it1 -> showToast(it1) }
                    }
                    Resource.Status.LOADING -> {
                        showLoading(true)
                        hideAllViews()
                    }
                }
            }
        })
    }

    private fun showLoading(isLoading: Boolean) {
        binding.swipeRefreshLayout.isRefreshing = isLoading
    }


    private fun handleNetworkChanges() {
        NetworkUtils.getNetworkLiveData(applicationContext).observe(this) { isConnected ->
            with(binding) {
                if (!isConnected) {
                    textViewNetworkStatus.text =
                        getString(R.string.text_no_connectivity)
                    networkStatusLayout.apply {
                        show()
                        setBackgroundColor(getColorRes(R.color.color_network_not_connected))
                    }
                } else {
                    textViewNetworkStatus.text = getString(R.string.text_connectivity)
                    networkStatusLayout.apply {
                        setBackgroundColor(getColorRes(R.color.color_network_connected))
                        animate()
                            .alpha(1f)
                            .setStartDelay(ANIMATION_DURATION)
                            .setDuration(ANIMATION_DURATION)
                            .setListener(object : AnimatorListenerAdapter() {
                                override fun onAnimationEnd(animation: Animator) {
                                    hide()
                                }
                            })
                    }
                }
            }

        }
    }

    private fun showAllViews() = with(binding) {
        formRecyclerView.show()
        progressBar.hide()

    }

    private fun hideAllViews() = with(binding) {
        formRecyclerView.hide()
        progressBar.hide()

    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    companion object {
        const val ANIMATION_DURATION = 1000L
    }
}