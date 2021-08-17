package com.example.syncassignment.di

import com.example.syncassignment.ui.deals.DealsFragment
import com.example.syncassignment.ui.deals.DealsViewModel
import dagger.Component

@Component(modules =[DealServicesModule::class])
interface DealServiceComponent {

    fun inject(dealFragment: DealsFragment)

}