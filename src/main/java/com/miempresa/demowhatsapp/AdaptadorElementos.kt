package com.miempresa.demowhatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class AdaptadorElementos(val listaElementos:ArrayList<Elementos>):
    RecyclerView.Adapter<AdaptadorElementos.ViewHolder>(){

    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val fTexto = itemView.findViewById<TextView>(R.id.elemento_texto)
        val fTexto2 = itemView.findViewById<TextView>(R.id.elemento_texto2)
        val fImagen = itemView.findViewById<ImageView>(R.id.elemento_imagen)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorElementos.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.elementoslista, parent, false);
        return ViewHolder(v);
    }

    override fun onBindViewHolder(holder: AdaptadorElementos.ViewHolder, position: Int) {
        holder?.fTexto?.text=listaElementos[position].texto
        holder?.fTexto2?.text=listaElementos[position].texto2
        holder?.fImagen?.setImageBitmap(listaElementos[position].imagen)

        holder.itemView.setOnClickListener(){
            val contacto:String = "Contacto "+(position+1)
            Toast.makeText(holder.itemView.context ,
                contacto,Toast.LENGTH_SHORT).show()

        }
    }

    override fun getItemCount(): Int {
        return listaElementos.size;
    }

}