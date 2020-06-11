package com.nymeria.aloha

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        btn_signin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {

            }

            startActivity(intent)
        }
    }
}