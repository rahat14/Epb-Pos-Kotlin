package com.syntex_error.epbpos_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syntex_error.epbpos_kotlin.databinding.ActivityMainBinding
import com.syntex_error.epbpos_kotlin.ui.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pos.setOnClickListener {
            startActivity(Intent(applicationContext, ProductList::class.java))
        }

        binding.customer.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    Customers::class.java
                )
            )
        }

        binding.supplier.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    Suppliers::class.java
                )
            )
        }

        binding.expense.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    Expenses::class.java
                )
            )
        }

        binding.settings.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    Settings::class.java
                )
            )
        }



        binding.report.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    Report::class.java
                )
            )
        }

        binding.products.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    ProductSearch::class.java
                )
            )
        }

        binding.allOrders.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    AllOrders::class.java
                )
            )
        }


    }
}