package com.example.fragmentexample2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentexample2.databinding.FragmentNewBinding

class NewFragment: Fragment() {
    private lateinit var binding: FragmentNewBinding
    private var numFrag: Int? = null
    private var colorBack: Int? = null
    private var name: String? = null
    private val TAG = "FragmentNew - $numFrag"

    override fun onAttach(context: Context) {
        Log.d(TAG, "onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)

        // Si existen argumentos pasados en el Bundle desde la llamada, se asignan a las propiedades.
        // ARG_NUMFRAG y ARG_COLORBACK estan declaradas en MainActivity
        arguments?.let {
            numFrag = it.getInt(ARG_NUMFRAG)
            colorBack = it.getInt(ARG_COLORBACK)
            name = it.getString(ARG_STRING)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        binding = FragmentNewBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        /**
         * Use this fragment factory method to create a new instance of this fragment using the provided parameters
         *
         * @param nFrag Numero de fragment
         * @param cBack Color de fondo
         * @return A new instance of fragment NewFragment
         */
        @JvmStatic
        fun newInstance(nFrag: Int, cBack: Int, nameString: String) = NewFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_NUMFRAG, nFrag)
                putInt(ARG_COLORBACK, cBack)
                putString(ARG_STRING, nameString)
            }
        }
    }

    // Se modifican las propiedades en este metodo para asegurar que la activity esta creada y se evitan asi posibles fallos
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated")
        binding.frameRoot.setBackgroundColor(colorBack!!)
        binding.tvFragment.text = getString(R.string.greeting, name)
        super.onViewCreated(view, savedInstanceState)
    }

}