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
                holder.image.setImageResource(R.drawable.vermouth_rosso)
            }
            "Gin Dry" ->{
                holder.image.setImageResource(R.drawable.gin_dry)
            }
            "Liquore arancio e genziana" ->{
                holder.image.setImageResource(R.drawable.liquore_arancio)
            }
            "Liquore amaro" ->{
                holder.image.setImageResource(R.drawable.liquore_amaro)
            }
            "Vermouth Superiore di Torino | Bianco" ->{
                holder.image.setImageResource(R.drawable.vermouth_bianco)
            }
            "Sambuca Classica" ->{
                holder.image.setImageResource(R.drawable.sambuca)
            }
            "Limoncello Classico" ->{
                holder.image.setImageResource(R.drawable.limoncello)
            }
            "Amaretto" ->{
                holder.image.setImageResource(R.drawable.amaretto)
            }
            "Amaro Balsamico" ->{
                holder.image.setImageResource(R.drawable.amaro_balsamico)
            }
            "Amaro Classico" ->{
                holder.image.setImageResource(R.drawable.amaro_classico)
            }
            "Liquore alla Genziana" ->{
                holder.image.setImageResource(R.drawable.genziana)
            }
            "Liquore al Timo Serpillo" ->{
                holder.image.setImageResource(R.drawable.timo)
            }
            "Genepy di Balme" ->{
                holder.image.setImageResource(R.drawable.balme)
            }
            "Genepy Piemonte IG" ->{
                holder.image.setImageResource(R.drawable.genepy_piemonte)
            }
            "Grappa Molsin 5 botti" ->{
                holder.image.setImageResource(R.drawable.molsin)
            }
            "Grappa Classica" ->{
                holder.image.setImageResource(R.drawable.grappa_classica)
            }
            "Grappa di Amarone | Selezione Quaglia" ->{
                holder.image.setImageResource(R.drawable.amarone)
            }
            "Grappa Barolo del Cavaliere" ->{
                holder.image.setImageResource(R.drawable.grappa_barolo)
            }
            "Grappa di Moscato" ->{
            holder.image.setImageResource(R.drawable.grappa_moscato)
        }
            "Liquore al Chinotto" ->{
                holder.image.setImageResource(R.drawable.chinotto)
            }
            "Liquore alla Violetta" ->{
                holder.image.setImageResource(R.drawable.violetta)
            }
            "Liquore alla Liquirizia" ->{
                holder.image.setImageResource(R.drawable.liquirizia)
            }
            "Liquore alla Nocciola" ->{
                holder.image.setImageResource(R.drawable.nocciola)
            }
            "Liquore Orange Brandy" ->{
                holder.image.setImageResource(R.drawable.brandy)
            }
            "Amaro alle Erbe biologico" ->{
                holder.image.setImageResource(R.drawable.erbe_bio)
            }
            "Limoncello biologico" ->{
                holder.image.setImageResource(R.drawable.limoncello_bio)
            }
            "Genepy biologico" ->{
                holder.image.setImageResource(R.drawable.genepy_bio)
            }
            "Negroni 1919 | Liquore" ->{
                holder.image.setImageResource(R.drawable.negroni)
            }
            "Americano 1907 | Liquore" ->{
                holder.image.setImageResource(R.drawable.americano)
            }
            "Martinez 1887 | Liquore" ->{
                holder.image.setImageResource(R.drawable.martinez)
            }
        }
        holder.view.setOnClickListener{
            mListener?.selectItem(ItemsViewModel.idDoc,ItemsViewModel.collection)
        }
    }

    override fun getItemCount() = shoplList.size

    interface AdapterCallback {
        fun selectItem(idDoc: String, collection: String)
    }

    private var mListener: AdapterCallback? = null

    fun setOnCallback(mItemClickListener: AdapterCallback){
        mListener=mItemClickListener
    }

    class ViewHolder (val view: ViewGroup) : RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.productText1)
        val price: TextView = view.findViewById(R.id.price1)
        val image: ImageView = view.findViewById(R.id.product1)
    }
}