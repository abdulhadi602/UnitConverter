package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.unitconverter.ViewModels.ConversionViewModel
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var convertFromSpinner : Spinner
    private lateinit var inputValue : EditText
    private lateinit var outputValue : TextView
    private lateinit var convertTo: TextView
    lateinit var viewModel : ConversionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        InitViews()


    }
    val textWatcher : TextWatcher = object : TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {
            viewModel.setInput(inputValue.text.toString())
        }

    }
    val selectionListener = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            if (p0 != null) {
                viewModel.setFromID(p0.getItemAtPosition(p2).toString())
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
            TODO("Not yet implemented")
        }

    }
    private fun InitViews(){
        convertFromSpinner = findViewById(R.id.ConvertFrom)
        inputValue = findViewById(R.id.InputValue)
        outputValue = findViewById(R.id.OutputValue)
        convertTo = findViewById(R.id.ConvertedTo)
        convertFromSpinner.onItemSelectedListener = selectionListener


        viewModel = ViewModelProvider(this).get(ConversionViewModel::class.java)
        viewModel.convertTo.observe(this, Observer {
            convertTo.text = it
            viewModel.setInput(inputValue.text.toString())
        })
        convertFromSpinner.setSelection(0)

        inputValue.addTextChangedListener(textWatcher)
        viewModel.outputValue.observe(this, Observer {
            outputValue.text = it.toString()
        })
    }
}
