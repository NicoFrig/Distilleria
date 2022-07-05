package com.example.distilleria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var nameCart:TextView
    private lateinit var priceCart:TextView
    private lateinit var image:ImageView
    private lateinit var auth: FirebaseAuth
    private lateinit var db:FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = FirebaseFirestore.getInstance()
        nameCart = view.findViewById(R.id.detailCart)
        priceCart = view.findViewById(R.id.priceCart)
        image = view.findViewById(R.id.imageCart)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        val coll = db.collection("cart").document(auth.uid.toString()).get().addOnSuccessListener {
            nameCart.text = it["liquorName"].toString()
            priceCart.text = it["price"].toString()
            when (it["liquorName"]){
                "Vermouth Superiore di Torino | Rosso" ->{
                    image.setImageResource(R.drawable.vermouth_rosso)
                }
                "Gin Dry" ->{
                    image.setImageResource(R.drawable.gin_dry)
                }
                "Liquore arancio e genziana" ->{
                    image.setImageResource(R.drawable.liquore_arancio)
                }
                "Liquore amaro" ->{
                    image.setImageResource(R.drawable.liquore_amaro)
                }
                "Vermouth Superiore di Torino | Bianco" ->{
                    image.setImageResource(R.drawable.vermouth_bianco)
                }
                "Sambuca Classica" ->{
                    image.setImageResource(R.drawable.sambuca)
                }
                "Limoncello Classico" ->{
                    image.setImageResource(R.drawable.limoncello)
                }
                "Amaretto" ->{
                    image.setImageResource(R.drawable.amaretto)
                }
                "Amaro Balsamico" ->{
                    image.setImageResource(R.drawable.amaro_balsamico)
                }
                "Amaro Classico" ->{
                    image.setImageResource(R.drawable.amaro_classico)
                }
                "Liquore alla Genziana" ->{
                    image.setImageResource(R.drawable.genziana)
                }
                "Liquore al Timo Serpillo" ->{
                    image.setImageResource(R.drawable.timo)
                }
                "Genepy di Balme" ->{
                    image.setImageResource(R.drawable.balme)
                }
                "Genepy Piemonte IG" ->{
                    image.setImageResource(R.drawable.genepy_piemonte)
                }
                "Grappa Molsin 5 botti" ->{
                    image.setImageResource(R.drawable.molsin)
                }
                "Grappa Classica" ->{
                    image.setImageResource(R.drawable.grappa_classica)
                }
                "Grappa di Amarone | Selezione Quaglia" ->{
                    image.setImageResource(R.drawable.amarone)
                }
                "Grappa Barolo del Cavaliere" ->{
                    image.setImageResource(R.drawable.grappa_barolo)
                }
                "Grappa di Moscato" ->{
                    image.setImageResource(R.drawable.grappa_moscato)
                }
                "Liquore al Chinotto" ->{
                    image.setImageResource(R.drawable.chinotto)
                }
                "Liquore alla Violetta" ->{
                    image.setImageResource(R.drawable.violetta)
                }
                "Liquore alla Liquirizia" ->{
                    image.setImageResource(R.drawable.liquirizia)
                }
                "Liquore alla Nocciola" ->{
                    image.setImageResource(R.drawable.nocciola)
                }
                "Liquore Orange Brandy" ->{
                    image.setImageResource(R.drawable.brandy)
                }
                "Amaro alle Erbe biologico" ->{
                    image.setImageResource(R.drawable.erbe_bio)
                }
                "Limoncello biologico" ->{
                    image.setImageResource(R.drawable.limoncello_bio)
                }
                "Genepy biologico" ->{
                    image.setImageResource(R.drawable.genepy_bio)
                }
                "Negroni 1919 | Liquore" ->{
                    image.setImageResource(R.drawable.negroni)
                }
                "Americano 1907 | Liquore" ->{
                    image.setImageResource(R.drawable.americano)
                }
                "Martinez 1887 | Liquore" ->{
                    image.setImageResource(R.drawable.martinez)
                }
            }
        }
    }
}