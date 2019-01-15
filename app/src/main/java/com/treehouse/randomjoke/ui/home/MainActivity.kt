package com.treehouse.randomjoke.ui.home

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.treehouse.randomjoke.R
import com.treehouse.randomjoke.R.id.message
import com.treehouse.randomjoke.network.popServices
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_activity.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class MainActivity : AppCompatActivity(),HomeContract.View {


    private val RanAdapter = RanAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(
                GsonConverterFactory
                    .create()
            )
        val retrofit = retrofitBuilder
            .client(okHttpClient)
            .build()

        val popServices = retrofit.create(popServices::class.java)

        val homePresenter: HomeContract.Presenter = HomePresenter(popServices, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RanAdapter

        btnRandom.setOnClickListener{
            homePresenter.getRandomDetails(icon_url = String(),id = String(),
                url = String(),value = String())
        }
    }
    override fun showResults(results: List<com.treehouse.randomjoke.model.Response>)
    {
        RanAdapter.setData(results)
    }


    @SuppressLint("ResourceType")
    override fun showError(massege: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


}