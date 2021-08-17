package com.example.syncassignment.services

import com.example.syncassignment.data.DealItem
import io.reactivex.Single
import retrofit2.http.GET

interface DealApiInterface {

    @GET("v3/2aa5fc04-3ef2-45ee-b797-8d1a497f124c")
    fun getDeals(): Single<ArrayList<DealItem>>
}