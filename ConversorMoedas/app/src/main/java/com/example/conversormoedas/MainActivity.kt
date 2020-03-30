package com.example.conversosmoedas

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mViewHolder = ViewHolder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewHolder.editValue = findViewById(R.id.edit_value)
        mViewHolder.textDolar = findViewById(R.id.text_dolar)
        mViewHolder.textEuro = findViewById(R.id.text_euro)
        mViewHolder.buttonCalculate = findViewById(R.id.button_calculate)

        var btnCalcular = findViewById<Button>(button_calculate)
        btnCalcular.setOnClickListener(this)

        clearValues()
    }

    private fun <T> findViewById(buttonCalculate: T): T {
        return buttonCalculate;
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_calculate) {
            val value = mViewHolder.editValue!!.text.toString()
            if ("" == value) {
                Toast.makeText(this, R.string.informe_valor, Toast.LENGTH_LONG).show()
            } else {
                val real = java.lang.Double.valueOf(value)
                mViewHolder.textDolar!!.text = String.format("%.2f", real / 4)
                mViewHolder.textEuro!!.text = String.format("%.2f", real / 5)
            }
        }
    }

    private fun clearValues() {
        mViewHolder.textDolar!!.text = ""
        mViewHolder.textEuro!!.text = ""
    }

    private class ViewHolder {
        var editValue: EditText? = null
        var textDolar: TextView? = null
        var textEuro: TextView? = null
        var buttonCalculate: Button? = null
    }
}