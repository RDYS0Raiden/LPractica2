package com.example.lpractica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lpractica2.databinding.ActivityPantalla2Binding

class Pantalla2 : AppCompatActivity() {
    //no olvidar que apesar de que se cambie de pantalla otra vez se debe iniciar el binding
    private lateinit var binding: ActivityPantalla2Binding
    private var codigo1:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPantalla2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val cod ="${intent.getStringArrayExtra("llaveA")}"
        codigo1 =cod
        binding.btnIniciar.setOnClickListener {
        obtenerDatosyValidar()
        }
    }
private fun obtenerDatosyValidar(){

    val primeraletraN=binding.pltxtNombre.text
    val primeraletraA=binding.pltxtApellido.text

        if(primeraletraN.length<=3||primeraletraN.length==0||primeraletraA.length<3||primeraletraA.length==0){
            Toast.makeText(this,"Nombre o Apellido Invalido Verifique los datos",Toast.LENGTH_SHORT).show()
        }else{
            binding.apply {
                if(SW.isChecked){
                    txtcode.text="${primeraletraN.first().uppercase()}${primeraletraA.last().uppercase()}-C-$codigo1"

                }else{
                    txtcode.text="${primeraletraN.first().uppercase()}${primeraletraA.last().uppercase()}-S-$codigo1"
                }
            }
        }
}
}