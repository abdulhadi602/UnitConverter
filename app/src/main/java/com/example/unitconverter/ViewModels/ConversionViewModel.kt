package com.example.unitconverter.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.unitconverter.Core.Converter
import com.example.unitconverter.Models.ConversionValue

class ConversionViewModel : ViewModel() {
    private var convertFrom : MutableLiveData<String> = MutableLiveData()
    private var inputValue : MutableLiveData<Double> = MutableLiveData()
    val convertTo : LiveData<String> = Transformations.map(convertFrom){
        Converter.ConvertFromID(it)
    }
    val outputValue : LiveData<Double> = Transformations.map(inputValue){
        convertTo.value?.let { it1 -> Converter.CalculateOutPut(ConversionValue(it,it1)) }
    }
    fun setInput(input : String) {
        if(input.equals("")){
            return
        }
        inputValue.value = input.trim().toDouble()
    }
    fun setFromID(ID: String){
        if(ID.equals(convertFrom.value)){
            return
        }
        convertFrom.value = ID
    }
}