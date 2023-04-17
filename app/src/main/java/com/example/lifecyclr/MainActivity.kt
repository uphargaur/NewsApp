package com.example.lifecyclr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.lifecyclr.dataclass.News
import com.example.lifecyclr.dataclass.Newsadapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var recyclerView: RecyclerView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerView)
        getnew()
    }

    private fun getnew() {
        val news= NewsService.newInstance.fetchHeadlines("in",Constants.API_KEY)
        news.enqueue(object : Callback<News>
        {
            override fun onFailure(call: Call<News>, t: Throwable) {
                println(t.message)
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val newsresponse =response.body()
                newsresponse?.let {
                    recyclerView.adapter=Newsadapter(this@MainActivity,newsresponse.articles)
                }
                recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
            }
        })

    }
}