package com.example.syncassignment.ui.deals

import com.example.syncassignment.data.DealItem
import com.example.syncassignment.services.DealServices
import io.reactivex.Single
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DealsViewModelTest  {

    lateinit var serviceMock: DealServices

    lateinit var viewModel: DealsViewModel
    @Before
    public fun setUp() {
        MockitoAnnotations.initMocks(this);
        serviceMock = Mockito.mock(DealServices::class.java)
        viewModel = DealsViewModel()
        viewModel.setService(serviceMock)
    }

    @Test
    fun testRefreshDeals() {
        `when`(serviceMock.getDeals()).thenReturn(Single.just(ArrayList<DealItem>()))
        viewModel.refreshDeals()
    }
}