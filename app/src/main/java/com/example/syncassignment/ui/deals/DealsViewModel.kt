package com.example.syncassignment.ui.deals

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.syncassignment.data.DealItem
import com.example.syncassignment.di.DaggerDealServiceComponent
import com.example.syncassignment.services.DealServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DealsViewModel() : ViewModel() {

    var _deals = MutableLiveData<ArrayList<DealItem>>()
    var _progress = MutableLiveData<Boolean>()
    var _error = MutableLiveData<Boolean>()
    lateinit var dealServices: DealServices

    fun refreshDeals() {
        _progress.value = true
        _error.value = false
        dealServices.getDeals()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith( object: DisposableSingleObserver<ArrayList<DealItem>>() {
                override fun onSuccess(value: ArrayList<DealItem>?) {
                    value?.let {
                        println(it)
                        _progress.value = false
                        _error.value = false
                        _deals.value = it

                    }
                }

                override fun onError(e: Throwable?) {
                    println("Error")
                    _progress.value = false
                    _error.value = true
                }
            })
    }

    fun setService(dealServices: DealServices) {
        this.dealServices = dealServices
    }
}