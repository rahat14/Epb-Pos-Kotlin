package com.syntex_error.epbpos_kotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syntex_error.epbpos_kotlin.databinding.ActivityPosPageBinding

class PosPage : AppCompatActivity() {
    private lateinit var binding: ActivityPosPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPosPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}