package com.example.syncassignment.services
import com.example.syncassignment.data.DealItem
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class DealServices {
    val BASE_URL = "https://run.mocky.io/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    val apiInterface = retrofit.create(DealApiInterface::class.java)

    fun getDeals(): Single<ArrayList<DealItem>> {
        return apiInterface.getDeals()
    }
}