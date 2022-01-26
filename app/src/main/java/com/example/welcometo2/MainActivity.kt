package com.example.welcometo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.welcometo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    public lateinit var binding:ActivityMainBinding;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*
        binding.draw.setOnClickListener{
            binding.Card1.setImageResource(R.drawable.imagen1)
        }

        binding.baraja.setOnClickListener{
            binding.Card1.setImageResource(R.drawable.imagen2)
        }*/

    }

}