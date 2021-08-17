package com.example.syncassignment.ui.deals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.syncassignment.data.DealItem
import com.example.syncassignment.databinding.FragmentDealsBinding
import com.example.syncassignment.di.DaggerDealServiceComponent
import com.example.syncassignment.services.DealServices
import javax.inject.Inject

class DealsFragment : Fragment() {

    private lateinit var dealsViewModel: DealsViewModel
    private var _binding: FragmentDealsBinding? = null

    private lateinit var listView: RecyclerView
    private lateinit var progress: ProgressBar
    private lateinit var errorTextView:TextView

    private var adapter = DealItemAdapter(ArrayList<DealItem>())

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    @Inject
    lateinit var dealServices: DealServices

    init {
        DaggerDealServiceComponent.create().inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dealsViewModel =
            ViewModelProvider(this).get(DealsViewModel::class.java)
        dealsViewModel.setService(dealServices)
        _binding = FragmentDealsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        listView = binding.recyclerViewDealItemList
        listView.layoutManager = LinearLayoutManager(activity)
        listView.adapter = adapter
        progress = binding.progressBar
        errorTextView = binding.textViewErrorMessage
        dealsViewModel._deals.observe(viewLifecycleOwner, Observer {
            listView.visibility = View.VISIBLE
            refreshDealList(it)
        })
        dealsViewModel._progress.observe(viewLifecycleOwner, Observer {
            if(it) {
                progress.visibility = View.VISIBLE
                listView.visibility = View.GONE
            } else  {
                progress.visibility = View.GONE
            }
        })
        dealsViewModel._error.observe(viewLifecycleOwner, Observer {
            if(it) {
                errorTextView.visibility = View.VISIBLE
                listView.visibility = View.GONE
            } else  {
                errorTextView.visibility = View.GONE
            }
        })
        adapter.setOnRecycleItemClickListener( object: DealItemAdapter.RecyclerItemClickListener {
            override fun onClick(dealItem: DealItem) {
                var bundle: Bundle = Bundle()
                bundle.putParcelable("deal-item",dealItem)
                var action = DealsFragmentDirections.actionNavigationDealsToNavigationDealDetail(dealItem)
                findNavController().navigate(action)
            }

        })
        return root
    }

    override fun onStart() {
        super.onStart()
        dealsViewModel.refreshDeals()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun refreshDealList(listData: ArrayList<DealItem>) {
        adapter.setData(listData)
        adapter.notifyDataSetChanged()
    }


}