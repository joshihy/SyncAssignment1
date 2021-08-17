package com.example.syncassignment.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/*
      "id":"383747",
      "name":"Preorder Samsung Galaxy Z Fold 3 5G and Galaxy Z Fold3 5G Unlocked + $200 Accessory Credit",
      "description":"Preorder Samsung Galaxy Z Fold 3 5G and Galaxy Z Fold3 5G Unlocked + $200 Accessory Credit on sale from $999.99 when you trade-in a qualifying device. \nNot: If you already reserved your phone, you will receive and additional $100 trade-in credit",
      "type":"h",
      "cost":999.99,
      "original_cost":1200.00,
      "provider":"Samsung",
      "product_link":"https://picsum.photos/200",
      "image_url":"https://picsum.photos/200",
      "like_count":11,
      "comments_count":4,
      "shipping_cost":0.0
 */


@Parcelize
data class DealItem(val id:String,
                    val name:String,
                    val description:String,
                    val type: String,
                    val cost: Double,
                    val original_cost: Double,
                    val provider: String,
                    val product_link: String,
                    val image_url: String,
                    val like_count: Int,
                    val comments_count: Int,
                    val shipping_cost: Double): Parcelable
