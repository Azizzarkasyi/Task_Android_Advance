package com.example.task_android_advance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class mahasiswa_adapter(private val mahasiswa_list: ArrayList<item_mahasiswa>)
    :RecyclerView.Adapter<mahasiswa_adapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mahasiswa_list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val mahasiswa = mahasiswa_list[position]
        holder.image.setImageResource(mahasiswa.gambar)
        holder.nama.text = mahasiswa.nama
        holder.npm.text = mahasiswa.nim
        holder.Notelpon.text = mahasiswa.telpon


    }
    class MyViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView){
        val  image : ImageView = itemView.findViewById(R.id.imageView)
        val  nama : TextView = itemView.findViewById(R.id.textView)
        val  npm : TextView = itemView.findViewById(R.id.textView2)
        val  Notelpon : TextView = itemView.findViewById(R.id.textView3)

    }
}