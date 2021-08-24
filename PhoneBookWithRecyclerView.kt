package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PhoneBookWithRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler_view)


        val phoneBookRecyclerAdapter = PhoneBookRecyclerAdapter(phonebookList = createFakePhoneBookd(faskeNumber = 30), LayoutInflater.from(this@PhoneBookWithRecyclerView), activity = this )
        val phonebook_recycler_view : RecyclerView = findViewById(R.id.phonebook_recycler_view)

        with(phonebook_recycler_view) {
            this.adapter = phoneBookRecyclerAdapter
            this.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerView)
        }
    }


    fun createFakePhoneBookd(faskeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()) : PhoneBook {
        for (i in 0 until faskeNumber) {
            phoneBook.addPerson(
                Person(name = "" + i + "번째 사람", number = "" + i + "번째 사람의 전화번호")
            )
        }
        return phoneBook
    }
}

class PhoneBookRecyclerAdapter(
    val phonebookList : PhoneBook,
    val inflater: LayoutInflater,
    val activity : Activity
) : RecyclerView.Adapter<PhoneBookRecyclerAdapter.Viewholder> () {
    inner class Viewholder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val personName : TextView
        init {
            personName = itemView.findViewById(R.id.person_name)
            itemView.setOnClickListener{
                val intent = Intent(activity, PhoneBookDetailActivity::class.java)
                intent.putExtra("name", phonebookList.personList.get(adapterPosition).name)
                intent.putExtra("number", phonebookList.personList.get(adapterPosition).number)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = inflater.inflate(R.layout.phonebook_item, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.personName.setText(phonebookList.personList.get(position).name)

    }

    override fun getItemCount(): Int {
        return phonebookList.personList.size
    }
}