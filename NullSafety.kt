package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity

class NullSafety : AppCompatActivity() {

//lateinit 개인적으로 사용하는 것 비추
//    lateinit var lateCar: Car

//    class Car(var number: Int) {

 //   }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_null_safety)

//        lateCar = Car(10)
//        Log.d("number", "late number : " + lateCar.number)

    //    val number : Int = 10
    //    val number1 : Int? = null

//!!는 사람이 보장하는 것으로 실수가 발생할 수 있다.
//!! -> 개발자가 null이 아님을 보장
//        val number5 : Int = number1!! + 10

    //    val number3 = number? + number1
    //    val number3 = number1?.plus(number)
    //    Log.d("number", "number3: "+number3)

        // 삼항 연산자 -> 엘비스 연산자(?:)
        // Null Safety를 위한 도구
    //    val number4 = number1 ?: 10
    //    Log.d("number", "number4 : " + number4)



    }

//    fun plus(a: Int, b:Int?) : Int {
//        if (b != null) return a+b
//        else return a
//    }

//    fun plus2(a: Int, b:Int?): Int? {
//        return b?.plus(a) // b가 null이  아니면 plus a를 리턴
//    }
//}