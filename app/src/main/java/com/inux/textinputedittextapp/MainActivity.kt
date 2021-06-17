package com.inux.textinputedittextapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.inux.textinputedittextapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.telefoneTextInputLayout.setEndIconOnClickListener {
            Toast.makeText(this, "Clicado!", Toast.LENGTH_LONG).show()
        }

        binding.telefoneEdt.doOnTextChanged { text, start, before, count ->
            if (text!!.length > 11) {
                binding.telefoneTextInputLayout.error = "Número de telefone incorreto."
            }else{
                binding.telefoneTextInputLayout.error = null
            }
        }
    }
}