package com.treehouse.randomjoke.ui.home


interface HomeContract{

    interface View {
        fun showResults(result: List<com.treehouse.randomjoke.model.Response>)
        fun showError(massege: String)
    }
    interface Presenter{

        fun getRandomDetails(icon_url:String, id:String, value:String, url: String)
    }
}