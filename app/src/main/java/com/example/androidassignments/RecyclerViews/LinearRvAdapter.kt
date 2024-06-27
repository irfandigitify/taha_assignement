package com.example.androidassignments.RecyclerViews

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignments.R

class LinearRvAdapter(private val dataSet:Array<LinearRvModel>):
    RecyclerView.Adapter<LinearRvAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        lateinit var imgView:ImageView
        lateinit var titleView:TextView
        lateinit var descripView:TextView
        lateinit var dateView: TextView

        init {
            imgView=view.findViewById(R.id.imageView2)
            titleView=view.findViewById(R.id.textView5)
            descripView=view.findViewById(R.id.editText)
            dateView=view.findViewById(R.id.textView7)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinearRvAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_linear_rv,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LinearRvAdapter.ViewHolder, position: Int) {
        holder.imgView.setImageResource(dataSet[position].imgSrc)
        holder.titleView.setText(dataSet[position].titleSrc)
        holder.descripView.setText(dataSet[position].descriptionSrc)
        holder.dateView.setText(dataSet[position].dateSrc)
    }

    override fun getItemCount()=dataSet.size
}