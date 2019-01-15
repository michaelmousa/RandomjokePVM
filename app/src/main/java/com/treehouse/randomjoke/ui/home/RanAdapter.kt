package com.treehouse.randomjoke.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.treehouse.randomjoke.R

class RanAdapter : RecyclerView.Adapter<RanAdapter.RanViewHolder>() {


    private val data = arrayListOf<com.treehouse.randomjoke.model.Response>()
    fun setData(data: List<com.treehouse.randomjoke.model.Response>) {

        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RanViewHolder {

        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return RanViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: RanViewHolder, position: Int)
    {
        viewHolder.bind(data[position])
    }

    class RanViewHolder(private val rootView: View) : RecyclerView.ViewHolder(rootView) {

        fun bind(data: com.treehouse.randomjoke.model.Response) {

            val tvIcon_url =rootView.findViewById<TextView>(R.id.tvIcon_url)
            tvIcon_url.text= data.icon_url.toString()

            val tvId =rootView.findViewById<TextView>(R.id.tvId)
            tvId.text= data.icon_url.toString()

            val tvUrl =rootView.findViewById<TextView>(R.id.tvUrl)
            tvUrl.text= data.icon_url.toString()

            val tvValue =rootView.findViewById<TextView>(R.id.tvValue)
            tvValue.text= data.icon_url.toString()


        }
    }
}