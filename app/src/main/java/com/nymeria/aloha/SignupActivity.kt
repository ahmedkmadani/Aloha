package com.nymeria.aloha

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_signup.*
import org.json.JSONException
import org.json.JSONObject

class SignupActivity : AppCompatActivity() {

    internal lateinit var viewDialog: ViewDialog
    internal lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        viewDialog = ViewDialog(this)

        link_signin.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java).apply {

            }

            startActivity(intent)
        }

        btn_signin.setOnClickListener {
            Signup()
        }
    }

    private fun Signup() {

        if (!validate()) {
            return
        }

        viewDialog.showDialog()

        val UserName = input_user_name!!.text.toString()
        val Password = input_password!!.text.toString()
        val ConfirmPassword = input_confirm_password!!.text.toString()
        val Email = input_email!!.text.toString()
        val PhoneNumber = input_phone!!.text.toString()
        val CompanyName = input_company!!.text.toString()
        val JobTitle = input_job!!.text.toString()
        val Twitter = input_twitter!!.text.toString()
        val Linkdin = input_linkidn!!.text.toString()


        val stringRequest = JsonObjectRequest(
            Request.Method.POST,URLs.URL_REGISTER + "?UserName=ahmed&Email=ahmed&Password=ahmed&PhoneNumber=ahmed&CompanyName=ahmed&JobTitle=ahmed&Twitter=ahmed&Linkdin=ahmed",null,
            Response.Listener { response ->

                try {

                    Log.d("res", response.toString())


                }catch (e:Exception){
                    onSiginFailed()
                    Log.d("Exception:", "" + e)
                }

            }, Response.ErrorListener{
                onSiginFailed()
                Log.d("Volley error :", "" + it)

            })


        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)
    }

//        val stringRequest = JsonObjectRequest(
//            Request.Method.POST,
//            URLs.URL_REGISTER,null,
//            Response.Listener { response ->
//                    Log.d("msg", response.toString())
//                try {
//
//
//                }catch (e:Exception){
//                    onSiginFailed()
//                    Log.d("Exception:", "" + e)
//                }
//
//            }, Response.ErrorListener{
//                onSiginFailed()
//                Log.d("Volley error :", "" + it)
//
//            })
//
//        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)
//    }



    private fun validate(): Boolean {
        var valid = true

        val UserName  = input_user_name!!.text.toString()
        val Password  = input_password!!.text.toString()
        val ConfirmPassword = input_confirm_password!!.text.toString()
        val Email = input_email!!.text.toString()
        val PhoneNumber = input_phone!!.text.toString()
        val CompanyName = input_company!!.text.toString()
        val JobTitle = input_job!!.text.toString()
        val Twitter = input_twitter!!.text.toString()
        val Linkdin = input_linkidn!!.text.toString()


        if (UserName.isEmpty()) {
            input_user_name!!.error = "enter a first name please !!"
            valid = false
        } else {
            input_user_name!!.error = null
        }

        if (Email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            input_email!!.error = "enter a valid email address please !!"
            valid = false
        } else {
            input_email!!.error = null
        }

        if (Password.isEmpty() || Password.length < 5 || Password.length > 10) {
            input_password!!.error = "between 5 and 10 alphanumeric characters"
            valid = false
        } else {
            input_password!!.error = null
        }

        if (ConfirmPassword.isEmpty() || !ConfirmPassword.contentEquals(Password)) {
            input_confirm_password!!.error = "password does'nt match !!"
            valid = false
        } else {
            input_confirm_password!!.error = null
        }


        if (PhoneNumber.isEmpty()) {
            input_phone!!.error = "enter a first name please !!"
            valid = false
        } else {
            input_phone!!.error = null
        }

        if (CompanyName.isEmpty()) {
            input_company!!.error = "enter a first name please !!"
            valid = false
        } else {
            input_company!!.error = null
        }

        if (JobTitle.isEmpty()) {
            input_job!!.error = "enter a first name please !!"
            valid = false
        } else {
            input_job!!.error = null
        }

        if (Twitter.isEmpty()) {
            input_twitter!!.error = "enter a first name please !!"
            valid = false
        } else {
            input_twitter!!.error = null
        }

        if (Linkdin.isEmpty()) {
            input_linkidn!!.error = "enter a first name please !!"
            valid = false
        } else {
            input_linkidn!!.error = null
        }


        return valid
    }


    private fun onSiginSuccess() {
        viewDialog.hideDialog()
        Snackbar.make(
            findViewById(android.R.id.content),
            "Sign up Successfully",
            Snackbar.LENGTH_LONG
        )
            .show()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun onSiginFailed() {
        viewDialog.hideDialog()
        Snackbar.make(findViewById<View>(android.R.id.content),
            "Sign up Failed",
            Snackbar.LENGTH_LONG
        )
            .setAction("Try Again") { v -> Signup() }.show()
    }

  }

