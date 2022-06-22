package com.example.distilleria

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class LiquorAdapter(private val liquorList: ArrayList<LiquorItem>, private val context: Context):
    RecyclerView.Adapter<LiquorAdapter.ViewHolder>(){
    var cont = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: ViewGroup
        if (cont%2 == 0)
        {
             view = LayoutInflater.from(parent.context).inflate(R.layout.liquor_item,parent,false) as ViewGroup
        }
        else
        {
             view = LayoutInflater.from(parent.context).inflate(R.layout.liquor_item_reverse,parent,false) as ViewGroup
        }
        cont ++
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = liquorList[position]

//        if(position%2 == 0) {
//            val singleLiquor = liquorList[position]
//
//            val singleLiquor2 = liquorList[position + 1]

            holder.titolo1.text = ItemsViewModel.title

            holder.desc1.text = ItemsViewModel.description

            when (holder.titolo1.text){
                "Amari 1890" -> {
                    holder.img.setImageResource(R.drawable.amaroclassico_ombra_quaglia)
                }
                "Bèrto" -> {
                    holder.img.setImageResource(R.drawable.quaglia_vermouth_bianco_ombra)
                }
                "Liquori Alpini" -> {
                    holder.img.setImageResource(R.drawable.liquorialpini)
                }
                "Le grappe" -> {
                    holder.img.setImageResource(R.drawable.grappe)
                }
                "I Classici Italiani" -> {
                    holder.img.setImageResource(R.drawable.classici)
                }
                "Vintage" -> {
                    holder.img.setImageResource(R.drawable.vintage)
                }
                "Elixir" -> {
                    holder.img.setImageResource(R.drawable.elixir_limoncello_quaglia)
                }
                "Mr. Quail & JT" -> {
                    holder.img.setImageResource(R.drawable.mrquail)
                }
            }

//        }
    }

    override fun getItemCount() = liquorList.size

    class ViewHolder (ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val titolo1: TextView = itemView.findViewById(R.id.category1)
        val desc1: TextView = itemView.findViewById(R.id.description1)
        val img: ImageView = itemView.findViewById(R.id.image1)
    }
}