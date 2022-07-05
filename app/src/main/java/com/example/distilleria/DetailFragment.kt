package com.example.distilleria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var back:ImageView
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var image:ImageView
    private lateinit var title:TextView
    private lateinit var description:TextView
    private lateinit var degree:TextView
    private lateinit var quantity:TextView
    private lateinit var priceDetail:TextView
    private lateinit var linesDetail:TextView
    private lateinit var cart:TextView
    private lateinit var piu:TextView
    private lateinit var meno: TextView
    private lateinit var cartQuant:TextView
    private lateinit var auth:FirebaseAuth


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
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.imageDetail)
        title = view.findViewById(R.id.titleDetail)
        description = view.findViewById(R.id.descriptionDetail)
        degree = view.findViewById(R.id.degree)
        quantity = view.findViewById(R.id.quantity)
        priceDetail = view.findViewById(R.id.priceDetail)
        meno = view.findViewById(R.id.meno)
        piu = view.findViewById(R.id.piu)
        cartQuant = view.findViewById(R.id.cartQuantity)
        linesDetail = view.findViewById(R.id.lineDetail)

        cart = view.findViewById(R.id.cartAdd)
        auth = Firebase.auth

        val db = Firebase.firestore
        db.collection(args.collection).document(args.idDoc).get().addOnSuccessListener {
            when (it["nome"]){
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
            title.text = it["nome"].toString()
            description.text = it["descrizione"].toString()
            degree.text = it["gradazione"].toString()
            quantity.text = it["quantita"].toString()
            priceDetail.text = it["prezzo"].toString()+"€"
            linesDetail.text = args.collection

        }

        cart.setOnClickListener{
            val currentUser = auth.currentUser
            val cartHashMap = hashMapOf (
                "liquorName" to title.text.toString(),
                "price" to priceDetail.text.toString()
            )
            db.collection("cart").document(currentUser!!.uid).set(cartHashMap)
                .addOnCompleteListener {
                    Toast.makeText(requireContext(),"Aggiunto al carrello",Toast.LENGTH_SHORT).show()
                }
        }
        piu.setOnClickListener{
            //Toast.makeText(requireContext(),"Cliccato",Toast.LENGTH_SHORT).show()
            var numQuant = cartQuant.text.toString().toInt()
            if(numQuant >= 10)
                Toast.makeText(requireContext(),"Hai raggiunto la massima quantità selezionabile",Toast.LENGTH_SHORT).show()
            else{
                numQuant++
                cartQuant.text = numQuant.toString()
            }
        }

        meno.setOnClickListener {
            var numQuant = cartQuant.text.toString().toInt()
            if(numQuant <= 1)
                Toast.makeText(requireContext(),"Hai raggiunto la minima quantità selezionabile",Toast.LENGTH_SHORT).show()
            else{
                numQuant--
                cartQuant.text = numQuant.toString()
            }
        }

        back=view.findViewById(R.id.backArrow)
        back.setOnClickListener{
            NavHostFragment.findNavController(this).navigate(R.id.action_detailFragment_to_shopFragment)
        }

    }

}