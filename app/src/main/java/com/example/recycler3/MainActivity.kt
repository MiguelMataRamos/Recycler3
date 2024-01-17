package com.example.recycler3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Clicks {
    private lateinit var bind: ActivityMainBinding
    private lateinit var adaptador: AdaptadorTarea
    private lateinit var data: MutableList<Tarea>

    override fun onCreate(savedInstanceState: Bundle?) {
        bind = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        data = mutableListOf(
            Tarea("Tarea 1", false),
            Tarea("Tarea 2", false),
            Tarea("Tarea 3", false),
            Tarea("Tarea 4", false),
            Tarea("Tarea 5", false),
            Tarea("Tarea 6", false),
            Tarea("Tarea 7", false),
            Tarea("Tarea 8", false),
            Tarea("Tarea 9", false),
            Tarea("Tarea 10", false)
        )

        adaptador = AdaptadorTarea(data, this)

        bind.recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adaptador
        }

        bind.botonAdd1.setOnClickListener {
            bind.textotareas.visibility = View.INVISIBLE
            bind.botonAdd1.visibility = View.INVISIBLE
            bind.botonAdd2.visibility = View.VISIBLE
            bind.textInputLayout.visibility = View.VISIBLE
        }

        bind.botonAdd2.setOnClickListener {
            var tarea = Tarea(bind.nuevatarea.text.toString(), false)
            data.add(tarea)
            adaptador.notifyDataSetChanged()
            bind.textotareas.visibility = View.VISIBLE
            bind.botonAdd2.visibility = View.INVISIBLE
            bind.botonAdd1.visibility = View.VISIBLE
            bind.textInputLayout.visibility = View.INVISIBLE
            bind.nuevatarea.setText("")
            popUp("Tarea añadida")
        }

    }

    //funcion que recibe un string y ejecuta un pop up  con el string
    fun popUp(texto: String){
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
    }
}