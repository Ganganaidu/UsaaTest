package com.usaa.ui.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.usaa.model.Child
import com.usass.R

class ProductAdapter(private val context: Context, private val listener: OnItemClickListener) :

    RecyclerView.Adapter<ProdcutHolder>() {

    private var childDataList: List<Child>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ProdcutHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list_view, viewGroup, false)
        return ProdcutHolder(view)
    }

    override fun getItemCount(): Int {
        return if (childDataList == null) 0 else childDataList!!.size
    }

    override fun onBindViewHolder(productHolder: ProdcutHolder, pos: Int) {
        val childData = childDataList!![pos].data

        productHolder.titleView.text = childData?.title

        productHolder.authorView.text =
            String.format("%s : %s ", context.getString(R.string.author), childData?.authorFullname)

        productHolder.commentsView.text = if (childData?.commentCount!! > 0)
            String.format(
                "%s : %s ",
                context.getString(R.string.comment),
                childData.commentCount
            ) else ""

        productHolder.itemView.setOnClickListener { listener.onItemClick(childData) }
    }

    fun updateAdapter(childDataList: List<Child>?) {
        this.childDataList = childDataList
        notifyDataSetChanged()
    }

}