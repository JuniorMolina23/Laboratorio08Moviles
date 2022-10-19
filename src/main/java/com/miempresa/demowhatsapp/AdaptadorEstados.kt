package com.miempresa.demowhatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorEstados(val listaElementos:ArrayList<Estados>):
    RecyclerView.Adapter<AdaptadorEstados.ViewHolder2>() {
    class ViewHolder2 (itemView: View):RecyclerView.ViewHolder(itemView){
        val fTitulo = itemView.findViewById<TextView>(R.id.estado_titulo)
        val fdescripcion = itemView.findViewById<TextView>(R.id.estado_descripcion)
        val fn1 = itemView.findViewById<TextView>(R.id.estado_n1)
        val fn2 = itemView.findViewById<TextView>(R.id.estado_n2)
        val fImagen = itemView.findViewById<ImageView>(R.id.estado_imagen)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorEstados.ViewHolder2 {
        val v =LayoutInflater.from(parent?.context).inflate(R.layout.elementosestados, parent, false);
        return ViewHolder2(v);
    }

    override fun onBindViewHolder(holder: AdaptadorEstados.ViewHolder2, position: Int) {
        holder?.fTitulo?.text=listaElementos[position].titulo
        holder?.fdescripcion?.text=listaElementos[position].descripcion
        holder?.fn1?.text=listaElementos[position].n1
        holder?.fn2?.text=listaElementos[position].n2
        holder?.fImagen?.setImageBitmap(listaElementos[position].imagen)
    }

    override fun getItemCount(): Int {
        return listaElementos.size;
    }
}