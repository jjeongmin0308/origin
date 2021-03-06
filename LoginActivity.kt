package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val register : TextView = findViewById(R.id.register)
        register.setOnClickListener{
            val intent = Intent(this, EmailSignupActivity::class.java)
            startActivity(intent)
        }

        val login : TextView = findViewById(R.id.login)
        val password_box : EditText = findViewById(R.id.password_box)
        val id_input : EditText = findViewById(R.id.id_input)
        login.setOnClickListener{
            val username = id_input.text.toString()
            val password = password_box.text.toString()
            (application as MasterApplication).service.login(username, password).enqueue(object : Callback<User>{
                override fun onFailure(call: Call<User>, t: Throwable) {

                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if(response.isSuccessful){
                        val user = response.body()
                        val token = user!!.token!!
                        saveUserToken(token, this@LoginActivity)
                        (application as MasterApplication).createRetrofit()
                        Toast.makeText(this@LoginActivity, "로그인 하셨습니다.", Toast.LENGTH_LONG).show()
                        startActivity(
                            Intent(this@LoginActivity, InstagramPostListActivity::class.java)
                        )

                    }




                }
            })
        }

    }

    fun saveUserToken(token:String, activity : Activity) {
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.commit()
    }

}