package com.example.exam.RvAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.R
import com.example.exam.modules.ItemPages
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item.view.*
import kotlinx.android.synthetic.main.rv_items.view.*

class RvAdapter(private val listener: listener): RecyclerView.Adapter<RvHolder>(){
    private val list = arrayListOf<ItemPages>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_items, parent, false)
        return RvHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RvHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    fun update(list: List<ItemPages>?) {
        if (list != null){
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

}

class RvHolder(v: View) : RecyclerView.ViewHolder(v) {

    fun bind(itemPages: ItemPages, listener: listener) {
        itemView.tvText.text = itemPages.name
        Picasso.get().load(itemView.context.getString(R.string.image_string))
            .into(itemView.itemImage)
        itemView.setOnClickListener {
            listener.itemsClick(itemPages)
        }

    }
}