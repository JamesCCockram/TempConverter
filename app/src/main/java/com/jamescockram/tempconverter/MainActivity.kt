package com.jamescockram.tempconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let{
            val textView_output = findViewById<TextView>(R.id.textView_output)
            textView_output.text = it.getString("output").toString()
        }


        var tempOutput = findViewById<TextView>(R.id.textView_output)
        var unit = findViewById<RadioGroup>(R.id.radioGroup_units)
        val button = findViewById<Button>(R.id.button_convert)

        button.setOnClickListener {
            val checked = unit.checkedRadioButtonId
            var tempInput = findViewById<EditText>(R.id.txtInput_temp)
            val temp = tempInput.text.toString().toDouble()
            var result = 0.0

            if(checked.equals(R.id.radioButton_celsius))
            {
                result = (temp * 9/5) + 32
            }
            else if(checked.equals(R.id.radioButton_f))
            {
                result = (temp - 32) * 5 / 9
            }
            else{
                result = 0.0
            }

            tempOutput.setText(result.roundToInt().toString())
        }
    }
    override fun onSaveInstanceState(outState: Bundle)
    {
        val textView_output = findViewById<TextView>(R.id.textView_output)

        outState.putString("output", textView_output.text.toString())
        super.onSaveInstanceState(outState)
    }
}