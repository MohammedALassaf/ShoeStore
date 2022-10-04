package com.udacity.shoestore

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeitemBinding
import timber.log.Timber

class ShoeDetail : Fragment() {

    val viewModel: ShoeDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeDetail_to_shoeListFragment)
        }
        binding.saveButton.setOnClickListener { view: View ->
            if (TextUtils.isEmpty(binding.shoeNameEdit.text) or TextUtils.isEmpty(binding.shoeSizeEdit.text) or TextUtils.isEmpty(
                    binding.companyNameEdit.text
                ) or TextUtils.isEmpty(binding.descriptionEdit.text)
            ) {
                Toast.makeText(this.context, "Please Enter All Required Fields", Toast.LENGTH_SHORT)
                    .show()
            } else {
                viewModel.shoeName.value = binding.shoeNameEdit.text.toString()
                viewModel.shoeSize.value = binding.shoeSizeEdit.text.toString()
                viewModel.company.value = binding.companyNameEdit.text.toString()
                viewModel.description.value = binding.descriptionEdit.text.toString()
                viewModel.addShoes(viewModel.shoeBuilder())
                view.findNavController().navigate(R.id.action_shoeDetail_to_shoeListFragment)
            }
        }

        return binding.root
    }

}