package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeDetailViewModel : ViewModel() {
    val shoeName = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    private var _shoeList = MutableLiveData<ArrayList<Shoe>>(ArrayList<Shoe>())
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList


    init {
        Timber.i("Shoe Detail View Model is Created!")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeViewModel Destroyed")
    }

    private fun change2Double(): Double {
        return shoeSize.value!!.toDouble()
    }


    fun shoeBuilder(): Shoe {
        Timber.i("Enter Shoe Builder")
        return Shoe(
            shoeName.value.toString(),
            change2Double(),
            company.value.toString(),
            description.value.toString()
        )
    }

    fun addShoes(shoe: Shoe) {
        val temp = _shoeList.value
        temp?.add(shoe)
        _shoeList.value = temp

    }
}