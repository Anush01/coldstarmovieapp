package com.example.anushmp.coldstarmovieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anushmp.coldstarmovieapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit

class SearchActivity : AppCompatActivity(), Clicker {

    lateinit var etSearchQuery: EditText
    lateinit var q: String
    lateinit var getbutton: TextView
    lateinit var rv: RecyclerView

    lateinit var nametest:String
    lateinit var movietitle:String
    lateinit var clicker: Clicker

    val key: String = "b72440004b952dc62c3b8f367ac3d52a"

    //original
    val urlprefix: String = "https://image.tmdb.org/t/p/w500"

    var urlList: ArrayList<String> = ArrayList()
    var titleList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        etSearchQuery = findViewById(R.id.etSearchQuery)
        getbutton = findViewById(R.id.getbutton)
        rv = findViewById(R.id.rvmovies)

        clicker = this


       // q = etSearchQuery.text.toString()
        // scaletype


        getbutton.setOnClickListener {

            q = etSearchQuery.text.toString()


            var browser: Retrofit = Networker.getRetrofit()

            var api = browser.create(Api::class.java)

            api.getposters(key,q).enqueue(object: Callback<Response>{
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    Log.d("q1logs","succeeded bro")

                    var resultlist : List<Results>? = response.body()?.results

                    if(resultlist != null){

                        var r: Results = resultlist[0]

                        nametest = r.title



                    }

                    Log.d("q1logs", nametest)

                    //run for loop add prefix build list and pass list to adapter.

                    urlList.clear()
                    titleList.clear()

                    if (resultlist != null) {
                        for (i in 0 until resultlist.size){

                            var poster_path = resultlist[i].poster_path
                            var urlcomplete: String = urlprefix + poster_path

                            movietitle = resultlist[i].original_title

                            urlList.add(urlcomplete)
                            titleList.add(movietitle)

                        }


                    }

                    var addy:PosterAdapter = PosterAdapter(urlList,titleList,clicker)

                    var glm: GridLayoutManager = GridLayoutManager(parent,4,GridLayoutManager.VERTICAL,false)

                    rv.adapter = addy
                    rv.layoutManager = glm

                }

                override fun onFailure(call: Call<Response>, t: Throwable) {
                    Log.d("q1logs","failed bro")
                }


            })






        }



    }

    override fun whenclicked(position: Int) {

        var title = titleList[position]

        Log.d("q1logs",title)

        //intent add title and fire the trailerviewacvtitiy

        var i: Intent = Intent(this,TrailerViewActivity::class.java)

        //context
        //this

        i.putExtra("title",title)

        startActivity(i)

    }


}