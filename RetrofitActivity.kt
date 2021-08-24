package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

// http://mellowcode.org/json/students/
        // http://mellowcode.org/test/code/
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            . addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        //GET 요청
        service.getStudentsList().enqueue(object : Callback<ArrayList<personn>>{

            override fun onFailure(call: Call<ArrayList<personn>>, t: Throwable) {
                Log.d ("retrofitt", "ERROR")
            }

            override fun onResponse(
                call: Call<ArrayList<personn>>,
                response: Response<ArrayList<personn>>
            ) {
                if (response.isSuccessful){
                    val personList = response.body()
                    Log.d("retrofitt", "res : " + personList?.get(0)?.age)

                    val code = response.code()
                    Log.d("retrofitt", "code : " + code)

                    val error = response.errorBody()
                    val hearder = response.headers()
                    Log.d("retrofitt", "code: " + hearder)

                }
            }
        })
        // POST 요청
 //       val params = HashMap<String, Any>()
 //       params.put("name", "홍정민")
 //       params.put("age", 22)
 //       params.put("intro", "안녕")


 //       service.createStudent(params).enqueue(object: Callback<personn>{
 //           override fun onFailure(call: Call<personn>, t: Throwable) {
 //               TODO("Not yet implemented")
 //           }

 //           override fun onResponse(
 //               call: Call<personn>,
 //               response: Response<personn>
 //           ) {
 //               if (response.isSuccessful){
 //                   val person = response.body()
 //                   Log.d("retrofitt", "name: " + person?.name)
 //               }
//
//            }
//        })

        //POST 요청 (2)
        val person = personn(name = "ㅋ", age = 2, intro = "안녕하세요 ㅋㅋ입니다.")
        service.createStudentEasy(person).enqueue(object : Callback<personn>{
            override fun onFailure(call: Call<personn>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<personn>,
                response: Response<personn>

            ) {
                if(response.isSuccessful) {
                    val person = response.body()
                    Log.d("retrofitt", "name :" + person?.name)
                }

            }
        })

    }
}