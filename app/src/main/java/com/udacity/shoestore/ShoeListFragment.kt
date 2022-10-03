package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeitemBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_list.view.*
import timber.log.Timber


class ShoeListFragment : Fragment() {

    private val viewModel: ShoeDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentShoeListBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_shoe_list , container, false)
        Timber.i("ViewModelProvider Created")
        binding.fab.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetail)
        }
        viewModel.shoeList.observe(viewLifecycleOwner) { newList ->
            Timber.i("" +newList.size)
            for (shoe in newList) {
                val shoeItem = ShoeitemBinding.inflate(layoutInflater, null, false)
                shoeItem.shoe = shoe
                binding.linearlayout.addView(shoeItem.root)
            }
        }

        return binding.root
    }



}