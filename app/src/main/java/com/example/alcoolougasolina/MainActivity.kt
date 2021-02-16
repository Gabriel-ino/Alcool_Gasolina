package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun btCalcular(view: View){

        val alcool = edit_preco_alcool.text.toString()
        val gasolina = edit_preco_gasolina.text.toString()

        var valida = validaDado(alcool, gasolina)

        if (valida == true){
            calculaPreco(alcool, gasolina)
        }else{
            text_resultado.text = "Você não preencheu todos os campos"
        }



    }

    fun validaDado(alcool: String, gasolina: String): Boolean{
        var validou = true
        if (alcool == null || alcool.equals("")){
            validou = false
        }
        else if (gasolina == null || gasolina.equals("")){
            validou = false
        }

        return validou
    }

    fun calculaPreco(alcool:String, gasolina: String){

        val valor_alcool = alcool.toDouble()
        val valor_gasolina = gasolina.toDouble()

        val result = valor_alcool / valor_gasolina

        if (result >= 0.7){
            text_resultado.text = "Melhor utilizar gasolina"
        }else{
            text_resultado.text = "Melhor utilizar álcool"
        }


    }


}