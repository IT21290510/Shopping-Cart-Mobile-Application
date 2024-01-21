package com.example.assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ClothesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClothesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val rootView = inflater.inflate(R.layout.fragment_clothes,container,false)

        val spinner: Spinner = rootView.findViewById(R.id.spinner)
        val saveButton: Button = rootView.findViewById(R.id.button)

        val viewModel = ViewModelProvider(requireActivity()).get(FragmentViewModel::class.java)

        val clotheNameTextView: TextView = rootView.findViewById(R.id.textView5)
        viewModel.getClotheName().observe(viewLifecycleOwner, Observer { clothesName ->
            clotheNameTextView.text = clothesName
        })

        saveButton.setOnClickListener {
            when(spinner.selectedItem.toString()){
                "blank" -> {}
                "Frocks" -> viewModel.setClotheName("Frocks")
                "Skirts" -> viewModel.setClotheName("Skirts")
                "Tshirts" -> viewModel.setClotheName("Tshirts")
                "Denims" -> viewModel.setClotheName("Denims")
                "Blouses" -> viewModel.setClotheName("Blouses")
                "Tops" -> viewModel.setClotheName("Tops")
            }
        }

        // Inflate the layout for this fragment
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ClothesFragmnet.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ClothesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}