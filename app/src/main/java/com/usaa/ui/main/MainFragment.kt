package com.usaa.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.usaa.MainActivity
import com.usaa.model.ChildData
import com.usaa.ui.main.adapter.OnItemClickListener
import com.usaa.ui.main.adapter.ProductAdapter
import com.usaa.viewmodel.MainViewModel
import com.usass.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(), OnItemClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var productAdapter: ProductAdapter? = null

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        recycleView.layoutManager = LinearLayoutManager(activity)
        progressBar.visibility = View.VISIBLE

        productAdapter = ProductAdapter(activity!!, this)
        recycleView.adapter = productAdapter

        viewModel.liveDataObserver.observe(this, Observer { redditModel ->
            progressBar.visibility = View.GONE
            if (redditModel == null) {
                Toast.makeText(activity, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
            } else {
                productAdapter?.updateAdapter(redditModel.mainData?.children)
            }
        })
    }

    override fun onItemClick(childData: ChildData?) {
        (activity as MainActivity).showDialog(childData)
    }
}
