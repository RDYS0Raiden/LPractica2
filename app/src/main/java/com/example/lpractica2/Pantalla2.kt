package com.example.lpractica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lpractica2.databinding.ActivityPantalla2Binding

class Pantalla2 : AppCompatActivity() {
    private lateinit var binding: ActivityPantalla2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPantalla2Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}