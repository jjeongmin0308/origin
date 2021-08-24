package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InstagramPostListActivity : AppCompatActivity() {

    lateinit var glide : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instagram_post_list)

        glide = Glide.with(this)

        (application as MasterApplication).service.getAllPosts().enqueue(
            object :Callback<ArrayList<Post>>{
                override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ArrayList<Post>>,
                    response: Response<ArrayList<Post>>
                ) {
                    if(response.isSuccessful) {
                        val postList = response.body()
                        val post_recyclerview : androidx.recyclerview.widget.RecyclerView = findViewById(R.id.post_recyclerview)
                        val adapter = PostAdapter(
                            postList!!,
                            LayoutInflater.from(this@InstagramPostListActivity),
                            glide

                        )
                        post_recyclerview.adapter = adapter
                        post_recyclerview.layoutManager = LinearLayoutManager(this@InstagramPostListActivity)


                    }
                }
            }
        )


    }


}

class PostAdapter(
    var postList : ArrayList<Post>,
    val inflater: LayoutInflater,
    val glide : RequestManager
) : RecyclerView.Adapter<PostAdapter.ViewHolder> () {

    inner class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        val postOwner : TextView
        val postImage : ImageView
        val postContent : TextView
        init {
            postOwner = itemView.findViewById(R.id.post_owner)
            postImage = itemView.findViewById(R.id.post_imag)
            postContent = itemView.findViewById(R.id.post_content)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.instagram_item_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postOwner.setText(postList.get(position).owner)
        holder.postContent.setText(postList.get(position).content)
        glide.load(postList.get(position).image).into(holder.postImage)
    }
}