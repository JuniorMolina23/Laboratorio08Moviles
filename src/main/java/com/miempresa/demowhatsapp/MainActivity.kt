package com.miempresa.demowhatsapp

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_info_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        lista.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this);

        var llenarLista = ArrayList<Elementos>()
        for (i in 1 until 15){
            llenarLista.add(Elementos("Contacto "+i,
                "Contacto"+i+": Mensaje "+i,
                BitmapFactory.decodeResource(resources,R.drawable.imagen2)))
        }
        val adapter = AdaptadorElementos(llenarLista)
        lista.adapter = adapter
        btn_estados.setOnClickListener(){
            var llenarLista = ArrayList<Estados>()
            for (i in 1 until 10){
                llenarLista.add(Estados("Titulo "+i,
                    "Descripcion del producto "+i,"+5000","4.5/5",
                    BitmapFactory.decodeResource(resources,R.drawable.google)))
            }
            val adapter = AdaptadorEstados(llenarLista)
            lista.adapter = adapter
        }
        btn_chats.setOnClickListener(){
            var llenarLista = ArrayList<Elementos>()
            for (i in 1 until 15){
                llenarLista.add(Elementos("Contacto "+i,
                    "Contacto"+i+": Mensaje "+i,
                    BitmapFactory.decodeResource(resources,R.drawable.imagen2)))
            }
            val adapter = AdaptadorElementos(llenarLista)
            lista.adapter = adapter
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_cuenta ->Toast.makeText(this,"Eligio Cuenta", Toast.LENGTH_SHORT).show()
        }
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id:Int = item.getItemId()
        if (id == R.id.ajustes){
            val llamaractividad = Intent(applicationContext,Ajustes::class.java)
            startActivity(llamaractividad)
            return true
        }
        if (id == R.id.acerca){
            //Toast.makeText(this,"Elegiste menu informacion",Toast.LENGTH_SHORT).show();
            val llamaractividad = Intent(applicationContext,Acerca::class.java)
            startActivity(llamaractividad)
            return true
        }
        if (id == android.R.id.home){
            layout_lateral.openDrawer(GravityCompat.START)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}