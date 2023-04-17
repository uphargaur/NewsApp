package com.example.lifecyclr.dataclass

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lifecyclr.R

class Newsadapter(private  val context : Context,private  val list :List<articles>):RecyclerView.Adapter<Newsadapter.Newsviewholder>() {
    class Newsviewholder(itemView :View):RecyclerView.ViewHolder(itemView) {
        val  titletext :TextView = itemView.findViewById(R.id.title)
        val  desctext :TextView = itemView.findViewById(R.id.content)
        val  image :ImageView = itemView.findViewById(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Newsviewholder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.newsitem,parent,false)
        return  Newsviewholder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Newsviewholder, position: Int) {
        holder.titletext.text=list[position].title
        holder.desctext.text=list[position].content
        Glide.with(context)
            .load(list[position].urlToImage)
            .into(holder.image)
    }

}