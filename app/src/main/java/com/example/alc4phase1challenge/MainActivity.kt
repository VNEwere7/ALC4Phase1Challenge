package com.example.alc4phase1challenge

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        aboutBtn.setOnClickListener {
            openAbout()
        }

        profileBtn.setOnClickListener {
            openProfile()
        }
    }

    fun openAbout() {
        startActivity(Intent(this@MainActivity, AboutActivity::class.java))

    }

    fun openProfile() {
        startActivity(Intent(this@MainActivity, ProfileActivity::class.java))

    }
}
