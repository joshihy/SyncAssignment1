package com.example.syncassignment.ui.deals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.syncassignment.R
import com.example.syncassignment.data.DealItem
import org.w3c.dom.Text
import android.graphics.Paint




class DealItemAdapter(var dealItems: ArrayList<DealItem>): RecyclerView.Adapter<DealItemAdapter.DealItemViewHolder>() {
    lateinit var recyclerItemClickListener:RecyclerItemClickListener
    lateinit var mainParent: ViewGroup
    fun setData(items:ArrayList<DealItem>) {
        dealItems.clear()
        dealItems = items
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder {
        mainParent = parent
        var rootView = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_cell, parent, false)
        return DealItemViewHolder(rootView)
    }

    inner class DealItemViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener{
        var itemName: TextView = itemView.findViewById<TextView>(R.id.item_name)
        var imageView: ImageView = itemView.findViewById<ImageView>(R.id.image_view)
        var itemCost: TextView = itemView.findViewById<TextView>(R.id.text_view_cost)
        var itemSeparator:View = itemView.findViewById<TextView>(R.id.view_separator)
        var itemOriginalCost: TextView = itemView.findViewById<TextView>(R.id.text_view_original_cost)
        var itemProvider: TextView = itemView.findViewById<TextView>(R.id.text_view_provider)
        var itemLikeCount: TextView = itemView.findViewById<TextView>(R.id.text_view_likes)
        var itemCommentsCount: TextView = itemView.findViewById<TextView>(R.id.text_view_comments)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            recyclerItemClickListener.onClick(dealItems[adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return dealItems.size
    }

    override fun onBindViewHolder(holder: DealItemViewHolder, position: Int) {
        holder.itemName.text = dealItems[position].name
        holder.itemCost.text = dealItems[position].cost.toString()
        Glide.with(mainParent.context).load(dealItems.get(position).image_url).into(holder.imageView)
        holder.itemCommentsCount.text = dealItems[position].comments_count.toString()
        holder.itemLikeCount.text = dealItems[position].like_count.toString()
        holder.itemProvider.text = "by " + dealItems[position].provider
        holder.itemOriginalCost.text = dealItems[position].original_cost.toString()
        holder.itemOriginalCost.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    }

    fun setOnRecycleItemClickListener(recyclerItemClickListener: DealItemAdapter.RecyclerItemClickListener) {
        this.recyclerItemClickListener = recyclerItemClickListener
    }

    interface RecyclerItemClickListener {
        fun onClick(dealItem:DealItem)
    }
}

