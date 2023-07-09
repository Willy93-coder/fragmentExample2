package com.example.fragmentexample2

import android.graphics.Color.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fragmentexample2.databinding.ActivityMainBinding

internal const val ARG_NUMFRAG = "numFrag"
internal const val ARG_COLORBACK = "colorBack"
internal const val ARG_STRING = "stringActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var numFrag = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            val name = binding.etInput.text.toString()
            Log.d("Prueba", "name = $name")
            showFragment(name)
        }
    }

    private fun showFragment(name: String) {
        val transaction = supportFragmentManager.beginTransaction()

        // Declaracion del fragment mediante newInstance
        /* val fragment1 = NewFragment.newInstance(
            ++numFrag,
            (if ((numFrag % 2) == 0) RED else GREEN)
        ) */

        // Declaracion basica del fragment
        val fragment = NewFragment()

        // Se crea la variable tipo Bundle para "empaquetar" los datos a pasar.
        val bundle = Bundle()
        bundle.putInt(ARG_NUMFRAG,  numFrag)
        bundle.putInt(ARG_COLORBACK, RED)
        bundle.putString(ARG_STRING, name)

        fragment.arguments = bundle
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}