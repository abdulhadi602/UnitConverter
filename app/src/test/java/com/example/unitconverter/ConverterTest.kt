package com.example.unitconverter

import com.example.unitconverter.Models.ConversionValue
import com.example.unitconverter.Utils.Converter
import org.junit.Test

import org.junit.Assert.*

class ConverterTest {

    @Test
    fun convertFromID_CM() {
        val input= "CM"
        val output = "M"
        val result = Converter.ConvertFromID(input)
        assertEquals(output,result)
    }
    @Test
    fun convertFromID_M() {
        val input= "M"
        val output = "CM"
        val result = Converter.ConvertFromID(input)
        assertEquals(output,result)
    }
    @Test
    fun convertFromID_KG() {
        val input= "KG"
        val output = "G"
        val result = Converter.ConvertFromID(input)
        assertEquals(output,result)
    }
    @Test
    fun convertFromID_G() {
        val input= "G"
        val output = "KG"
        val result = Converter.ConvertFromID(input)
        assertEquals(output,result)
    }
    @Test
    fun convertToCM() {
        val input= 1.0
        val output = 100.0
        val result = Converter.ConvertToCM(input)
        assertEquals(output,result,0.00001)
    }
    @Test
    fun convertToM() {
        val input= 1.0
        val output = 0.01
        val result = Converter.ConvertToM(input)
        assertEquals(output,result,0.00001)
    }
    @Test
    fun convertToKG() {
        val input= 1.0
        val output = 0.001
        val result = Converter.ConvertToKG(input)
        assertEquals(output,result,0.00001)
    }
    @Test
    fun convertToG() {
        val input= 1.0
        val output = 1000.0
        val result = Converter.ConvertToG(input)
        assertEquals(output,result,0.00001)
    }
    @Test
    fun CalculateOutPutG() {
        val output = 1000.0
        val result = Converter.CalculateOutPut(ConversionValue(1.0,"G"))
        assertEquals(output,result,0.00001)
    }
    @Test
    fun CalculateOutPutKG() {
        val output =  0.001
        val result = Converter.CalculateOutPut(ConversionValue(1.0,"KG"))
        assertEquals(output,result,0.00001)
    }
    @Test
    fun CalculateOutPutCM() {
        val output = 100.0
        val result = Converter.CalculateOutPut(ConversionValue(1.0,"CM"))
        assertEquals(output,result,0.00001)
    }
    @Test
    fun CalculateOutPutM() {
        val output = 0.01
        val result = Converter.CalculateOutPut(ConversionValue(1.0,"M"))
        assertEquals(output,result,0.00001)
    }
}