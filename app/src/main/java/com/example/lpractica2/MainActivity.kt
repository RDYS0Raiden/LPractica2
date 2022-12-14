package com.example.lpractica2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.lpractica2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var myHandler: Handler

        private var llaveA:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myHandler=Handler(mainLooper)
        binding.btnProcesar.setOnClickListener{
            IniciarHilo()
        }
    }
private fun IniciarHilo(){
    Thread{
        try {
            for(i in 0..10){
                Thread.sleep(1000)
                myHandler.post{
                    //va a comunicarse con la UI Thread
                    binding.apply{
                        txtcontador.text="$i%"
                        PBR.progress=i * 10
                    }
                }
            }
            runOnUiThread{
                Thread.sleep(500)
                binding.txtcontador.text="LISTO"
                GenerarCodigoRandom()
            }
            Thread.sleep(5000)
            PasarPantalla()

        }catch (e:InterruptedException){
            e.printStackTrace()
        }

    }.start()
}
    private fun PasarPantalla(){
        val cod=llaveA
    val intent=Intent(this,Pantalla2::class.java)
        intent.apply {
            putExtra("llaveA",cod)
        }
        startActivity(intent)
    }

    private fun GenerarCodigoRandom(){
        //se generara letras
        var letras1 =('A'..'Z').random()
        var letras2 =('A'..'Z').random()
        //se generara numeros random de 1 a 9
        var numeros1=(1..9).random()
        var numeros2=(1..9).random()
        //condicion
        while(numeros1==numeros2){
            numeros2=(1..9).random()
        }
        llaveA ="$letras1$letras2-$numeros1$numeros2"
        binding.txtcodigo.text=llaveA
    }


}