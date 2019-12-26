package com.rachitgoyal.gradientviewpagersample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rachitgoyal.gradientviewpagersample.model.Pasta

class PageViewModel : ViewModel() {

    private val _pasta = MutableLiveData<Pasta>()
    val text: LiveData<String> = Transformations.map(_pasta) {
        it.name
    }

    val desc: LiveData<String> = Transformations.map(_pasta) {
        it.description
    }

    val image: LiveData<Int> = Transformations.map(_pasta) {
        it.imageId
    }

    fun setData(pasta: Pasta) {
        _pasta.value = pasta
    }
}