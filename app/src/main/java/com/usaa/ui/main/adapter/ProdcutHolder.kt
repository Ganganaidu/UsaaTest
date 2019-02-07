package com.usaa.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.usass.R

class ProdcutHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var titleView: TextView = itemView.findViewById(R.id.titleView)
    var authorView: TextView = itemView.findViewById(R.id.authorView)
    var commentsView: TextView = itemView.findViewById(R.id.commentsView)

}