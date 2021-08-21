package com.example.unitconverter.Core

import com.example.unitconverter.Models.ConversionValue

object Converter {
//    fun ConvertFromID(from : String) : LiveData<String?> {
//        var To : String? = null
//        when(from){
//            "CM" -> To = "M"
//            "M"  -> To = "CM"
//            "KG" -> To = "G"
//            "G"  -> To = "KG"
//        }
//        return object : LiveData<String?>(){
//            override fun onActive() {
//                super.onActive()
//                value = To
//            }
//        }
//
//    }
    fun CalculateOutPut( conversionValue: ConversionValue) : Double{
        when(conversionValue.ConversionType){
            "CM" -> return ConvertToCM(conversionValue.input)
            "M"  -> return ConvertToM(conversionValue.input)
            "KG" -> return ConvertToKG(conversionValue.input)
            "G"  -> return ConvertToG(conversionValue.input)
            else -> return 0.0
        }
    }
    fun ConvertToCM(input : Double) : Double{
        return input.times(100)
    }
    fun ConvertToM(input: Double):Double{
        return input.div(100)
    }
    fun ConvertToG(input : Double) : Double{
        return input.times(1000)
    }
    fun ConvertToKG(input: Double):Double{
        return input.div(1000)
    }
    fun ConvertFromID(from : String) : String? {
        var To : String? = null
        when(from){
            "CM" -> To = "M"
            "M"  -> To = "CM"
            "KG" -> To = "G"
            "G"  -> To = "KG"
        }
        return To

    }
}