package com.nymeria.aloha

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        btn_sigin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {

            }

            startActivity(intent)

            link_signup.setOnClickListener {
                val intent = Intent(this, SignupActivity::class.java).apply {

                }

                startActivity(intent)
            }
        }
    }
}