package com.example.distilleria

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShopAdapter(private val shoplList: ArrayList<ShopItem>, private val context: Context):
    RecyclerView.Adapter<ShopAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): ShopAdapter.ViewHolder{
        val view:ViewGroup

        view = LayoutInflater.from(parent.context).inflate(R.layout.shop_item,parent,false) as ViewGroup

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int ){
        val ItemsViewModel = shoplList[position]

        holder.name.text = ItemsViewModel.title

        holder.price.text = ItemsViewModel.price

        when (holder.name.text){
            "Vermouth Superiore di Torino | Rosso" ->{
                holder.image.setImageResource(R.drawable.vermounth_rosso)
            }
            "Gin Dry" ->{
                holder.image.setImageResource(R.drawable.berto_gin)
            }
            "Liquore arancio e genziana" ->{
                holder.image.setImageResource(R.drawable.berto_aperitivo)
            }
            "Liquore amaro" ->{
                holder.image.setImageResource(R.drawable.berto_bitter)
            }
            "Vermouth Superiore di Torino | Bianco" ->{
                holder.image.setImageResource(R.drawable.vermounth_bianco)
            }
        }
    }

    override fun getItemCount() = shoplList.size

    class ViewHolder (val view: ViewGroup) : RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.productText1)
        val price: TextView = view.findViewById(R.id.price1)
        val image: ImageView = view.findViewById(R.id.product1)
    }
}