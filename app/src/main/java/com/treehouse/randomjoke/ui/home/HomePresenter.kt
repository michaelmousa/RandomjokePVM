package com.treehouse.randomjoke.ui.home

import com.treehouse.randomjoke.network.popServices
import retrofit2.Call
import retrofit2.Response
import java.net.URL

class HomePresenter (private val popServices: popServices,
                     private val view: HomeContract. View) : HomeContract.Presenter
{
    override fun getRandomDetails(icon_url: String, id: String,  url: String,value: String)
    {

    popServices.getRandomDetails().enqueue(object :
        retrofit2.Callback<com.treehouse.randomjoke.model.Response>
    {
        override fun onFailure(call: Call<com.treehouse.randomjoke.model.Response>, t: Throwable)
        {
            view.showError("Please try again")
        }

        override fun onResponse(
            call: Call<com.treehouse.randomjoke.model.Response>,
            response: Response<com.treehouse.randomjoke.model.Response>)
        {
            if (response.isSuccessful)
            {
                val resultList  = arrayListOf<com.treehouse.randomjoke.model.Response>(response.body() ?: com.treehouse .randomjoke.model.Response("","","",""))
                view.showResults(resultList)
            }
            else{

                view.showError("An unknown error occurred")
            }
        }


    })

    }


}