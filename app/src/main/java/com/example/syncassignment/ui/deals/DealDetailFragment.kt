package com.example.syncassignment.ui.deals

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.syncassignment.R
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.syncassignment.MainActivity
import com.example.syncassignment.data.DealItem
import com.example.syncassignment.databinding.FragmentDealDetailBinding



class DealDetailFragment : Fragment(R.layout.fragment_deal_detail) {

    private val binding get() = _binding!!
    private var _binding: FragmentDealDetailBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var dealItem = arguments?.getParcelable<DealItem>("deal_data")
        println(dealItem?.cost)

        _binding = FragmentDealDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var textViewItemName = root.findViewById<TextView>(R.id.text_view_item_name)
        var textViewDescription = root.findViewById<TextView>(R.id.text_view_item_description)
        var imageView = root.findViewById<ImageView>(R.id.image_view)

        var textViewCost: TextView = root.findViewById<TextView>(R.id.text_view_cost)
        var textViewOriginalCost: TextView = root.findViewById<TextView>(R.id.text_view_cost_original)
        var textViewProvider: TextView = root.findViewById<TextView>(R.id.text_view_provider)
        var textViewLikeCount: TextView = root.findViewById<TextView>(R.id.text_view_likes)
        var textViewCommentsCount: TextView = root.findViewById<TextView>(R.id.text_view_comments)


        dealItem?.let {
            textViewItemName.text = it.name
            Glide.with(this).load(it.image_url).into(imageView)
            textViewCost.text = "$" +it.cost
            textViewOriginalCost.text = "$" +it.original_cost
            textViewOriginalCost.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            textViewProvider.text = "by " + it.provider
            textViewLikeCount.text = it.like_count.toString()
            textViewCommentsCount.text = it.comments_count.toString()
            textViewDescription.text = it.description
        }
        /*val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true *//* enabled by default *//*) {
                override fun handleOnBackPressed() {
                    println("test")
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this.activity as MainActivity, callback)*/


        return root
    }

}