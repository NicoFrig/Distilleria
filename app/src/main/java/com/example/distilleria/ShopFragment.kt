package com.example.distilleria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavArgs
import android.widget.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShopFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShopFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val shopList= ArrayList<ShopItem>()
    val args: ShopFragmentArgs by navArgs()

    private lateinit var prod: ImageView

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
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        prod = view.findViewById(R.id.product1)
        val db = Firebase.firestore
        db.collection(args.title).get().addOnSuccessListener { documents ->
            for(document in documents){
                var title = document["nome"].toString()
                var price = document["prezzo"].toString()
                val nuovoShop = ShopItem(title,price)
                shopList.add(nuovoShop)
                val recycleView = view.findViewById<RecyclerView>(R.id.recycle)
                val adapter = ShopAdapter(shopList,requireActivity())
                recycleView.adapter = adapter
                recycleView.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            }
        }
//        prod.setOnClickListener{
//              val frag=activity?.supportFragmentManager?.beginTransaction()
//              frag?.replace(R.id.fragmentContainer, DetailFragment())
//              frag?.disallowAddToBackStack()
//              frag?.commit(

           //NavHostFragment.findNavController(this).navigate(R.id.action_shopFragment_to_detailFragment)
//        }

        val spinnerLines: Spinner = view.findViewById(R.id.spinnerLines)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            view.context,
            R.array.filterLines,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerLines.adapter = adapter
        }

        val spinnerPrices: Spinner = view.findViewById(R.id.spinnerPrices)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            view.context,
            R.array.filterPrices,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerPrices.adapter = adapter
        }

        val spinnerOrderBy: Spinner = view.findViewById(R.id.spinnerOrderBy)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            view.context,
            R.array.filterOrderBy,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerOrderBy.adapter = adapter
        }

        val filterLayout = view.findViewById<LinearLayout>(R.id.filterLayout)
        val orderByLayout = view.findViewById<LinearLayout>(R.id.orderByLayout)
        val filter = view.findViewById<TextView>(R.id.filter)
        val orderBy = view.findViewById<TextView>(R.id.orderBy)

        filter.setOnClickListener {
            orderByLayout.visibility = View.GONE
            if (filterLayout.visibility == View.GONE) {
                filterLayout.visibility = View.VISIBLE
            } else {
                filterLayout.visibility = View.GONE
            }
        }

        orderBy.setOnClickListener {
            filterLayout.visibility = View.GONE
            if (orderByLayout.visibility == View.GONE) {
                orderByLayout.visibility = View.VISIBLE
            } else {
                orderByLayout.visibility = View.GONE
            }
        }
    }
}