package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val clothesFragment = ClothesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)

        button8.setOnClickListener{
            loadHome()
        }

        button9.setOnClickListener {
            loadClothes()
        }

        button7.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun loadHome(){
        val fragment = supportFragmentManager.findFragmentById(R.id.FragmentContainer)

        if (fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.FragmentContainer,homeFragment).commit()
        }else {
            supportFragmentManager.beginTransaction().replace(R.id.FragmentContainer,homeFragment).commit()
        }
    }

    private fun loadClothes(){
        val fragment = supportFragmentManager.findFragmentById(R.id.FragmentContainer)

        if (fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.FragmentContainer,clothesFragment).commit()
        }else {
            supportFragmentManager.beginTransaction().replace(R.id.FragmentContainer,clothesFragment).commit()
        }

    }



}