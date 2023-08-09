package com.example.googlemapsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val placeList: ArrayList<Places>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val placeIcon = itemView.findViewById<ImageView>(R.id.placeIcon)
        val placeText = itemView.findViewById<TextView>(R.id.placeText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.placeIcon.setImageResource(placeList[position].icon)
        holder.placeText.text =  placeList[position].placeName
    }
}