package com.example.cityreport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cityreport.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Respetamos la inflación del layout mediante View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}