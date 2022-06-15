package com.example.distilleria

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import io.grpc.Context

class LiquorAdapter(private val liquorList: ArrayList<LiquorItem>, private val context: FragmentActivity):
    RecyclerView.Adapter<LiquorAdapter.CustomViewHolder>(){

    class CustomViewHolder (val view:ViewGroup):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.liquor_item,parent,false) as ViewGroup
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {


        if(position%2 === 0){
            val singleLiquor = liquorList[position]

            val singleLiquor2 = liquorList[position+1]

            val title = holder.view.findViewById<TextView>(R.id.category1)
            title.text=singleLiquor.title

            val desc = holder.view.findViewById<TextView>(R.id.description1)
            desc.text=singleLiquor.description

            val title2 = holder.view.findViewById<TextView>(R.id.category2)
            title2.text = singleLiquor2.title

            val desc2 = holder.view.findViewById<TextView>(R.id.description2)
            desc2.text = singleLiquor2.description
        }
        else
        {
            val constraintCard = holder.view.findViewById<ConstraintLayout>(R.id.constraintCard)
            constraintCard.removeAllViews()
        }
    }

    override fun getItemCount()= liquorList.size
}