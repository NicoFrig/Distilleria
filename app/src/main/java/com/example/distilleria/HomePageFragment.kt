package com.example.distilleria

import android.app.AlertDialog
import android.icu.text.CaseMap
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomePageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomePageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val liquorList = ArrayList<LiquorItem>()
    private lateinit var nome: TextView
    private lateinit var descrizione: TextView
    private lateinit var db: FirebaseFirestore

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
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db=FirebaseFirestore.getInstance()
        for(i in 8 downTo 1)
        {
            liquorList.clear()
            db.collection("lines").document(i.toString()).get().addOnCompleteListener {
                if (it.isSuccessful) {
                    var title = it.result.data?.get("nome").toString()
                    var desc = it.result.data?.get("descrizione").toString()
                    val nuovoLiq = LiquorItem(title, desc)
                    liquorList.add(nuovoLiq)
                    val recycleView = view.findViewById<RecyclerView>(R.id.recycle)
                    val adapter = LiquorAdapter(liquorList,requireActivity())
                    adapter.setOnCallback(object: LiquorAdapter.AdapterCallback{
                        override fun selectItem(title:String){
                            val action = HomePageFragmentDirections.actionHomePageFragmentToShopFragment(title)
                            NavHostFragment.findNavController(this@HomePageFragment).navigate(action)
                            //Toast.makeText(requireContext(), title, Toast.LENGTH_SHORT).show()
                        }
                    })
                    recycleView.adapter = adapter
                    recycleView.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
                }
            }
        }
    }
}