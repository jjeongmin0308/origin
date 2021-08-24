package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReCyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_re_cycler_view)

        val carList = ArrayList<CarForList> ()
        for (i in 0 until 50) {
            carList.add(CarForList(""+i+"번째자동차", ""+ i +"순위엔진"))
        }
        val adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this@ReCyclerViewActivity))
        val recycler_view : RecyclerView = findViewById(R.id.recycler_view)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this@ReCyclerViewActivity)
        // recycler_view.layoutManager = GridLayoutManager(this@ReCyclerViewActivity, 2)

    }
}

class RecyclerViewAdapter(
    val itemList : ArrayList<CarForList>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val carName : TextView
        val carEngine : TextView
        init { // 초기화 블록
            carName = itemView.findViewById(R.id.car_name)
            carEngine = itemView.findViewById(R.id.car_engine)
            itemView.setOnClickListener{
                val position : Int = adapterPosition
                val engineName = itemList.get(position).engine
                Log.d("engine",engineName)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.setText(itemList.get(position).name)
        holder.carEngine.setText(itemList.get(position).engine)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}