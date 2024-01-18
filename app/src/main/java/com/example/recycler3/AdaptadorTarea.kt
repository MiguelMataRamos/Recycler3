package com.example.recycler3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler3.databinding.ItemTareaBinding

class AdaptadorTarea(var listatareas: MutableList<Tarea>, var listener: Clicks) :
    RecyclerView.Adapter<AdaptadorTarea.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bind =
            ItemTareaBinding.bind(view)//esta linea es la que nos permite acceder a los elementos del layout

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarea, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listatareas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var tarea = listatareas[position]

        holder.bind.Tarea.text = tarea.nombre
        holder.bind.Tarea.isChecked = tarea.completado

        holder.bind.Tarea.setOnLongClickListener {
            listener.onlongclick(tarea, position)
        }
    }


}