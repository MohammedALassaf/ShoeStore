package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {
    var SshoeList = MutableLiveData<ArrayList<Shoe>>(ArrayList<Shoe>())
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = SshoeList
    init {
        Timber.i("ShoeViewModel Created!")
    }

    fun addShoes(shoe: Shoe){
        val temp = SshoeList.value
        temp?.add(shoe)
        SshoeList.value = temp

    }

}