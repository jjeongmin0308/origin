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

class EmailSignupActivity : AppCompatActivity() {

    lateinit var usernameView : EditText
    lateinit var userPassword1View : EditText
    lateinit var userPassword2View : EditText
    lateinit var registerBtn : TextView
    lateinit var loginBtn : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_signup)

        initView(this@EmailSignupActivity)
        setUpListener(this)

    }
    fun setUpListener(activity: Activity) {
        registerBtn.setOnClickListener{
            register(this@EmailSignupActivity)
        }
        loginBtn.setOnClickListener{
            startActivity(
                Intent(this@EmailSignupActivity, LoginActivity::class.java)
            )
        }

    }
    fun register(activity: Activity) {
        val username = getUserName()
        val password1 = getUserPassword1()
        val password2 = getUserPassword2()

        (application as MasterApplication).service.register(username, password1, password2).enqueue(object: Callback<User>{
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(activity, "가입에 실패 했습니다.", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful) {
                    Toast.makeText(activity, "가입에 성공 했습니다.", Toast.LENGTH_LONG).show()
                    val user = response.body()
                    val token = user!!.token!!
                    saveUserToken(token, activity)
                    (application as MasterApplication).createRetrofit()

                    activity.startActivity(
                        Intent(activity, InstagramPostListActivity::class.java)
                    )

                }

            }
        })
    }

    fun saveUserToken(token : String, activity: Activity) {
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.commit()
    }

    fun initView(activity: Activity) {
        usernameView = activity.findViewById(R.id.id_input)
        userPassword1View = activity.findViewById(R.id.password1_input)
        userPassword2View = activity.findViewById(R.id.password2_input)
        registerBtn = activity.findViewById(R.id.register)
        loginBtn = activity.findViewById(R.id.login)
    }

    fun getUserName(): String{
        return usernameView.text.toString()
    }

    fun getUserPassword1():String{
        return userPassword1View.text.toString()

    }
    fun getUserPassword2():String{
        return userPassword2View.text.toString()

    }

}