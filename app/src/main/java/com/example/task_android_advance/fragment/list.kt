package com.example.task_android_advance.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task_android_advance.R
import com.example.task_android_advance.item_mahasiswa
import com.example.task_android_advance.mahasiswa_adapter

class list : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemMahasiswa: ArrayList<item_mahasiswa>
    private lateinit var mahasiswaAdapter: mahasiswa_adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val next= inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = next.findViewById(R.id.recyleview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(context)
        itemMahasiswa = ArrayList()
//        recyclerView.layoutManager= LinearLayoutManager(t)
        itemMahasiswa.add(item_mahasiswa(R.drawable.img_3,"andri cahyo","26473647674","098523673644"))
        itemMahasiswa.add(item_mahasiswa(R.drawable.img_1,"putri indah","726472648","083453333553"))
        itemMahasiswa.add(item_mahasiswa(R.drawable.img_2,"andin liya","985497397","081234658847"))
        itemMahasiswa.add(item_mahasiswa(R.drawable.img_3,"febri sifa","347856781365","082354772828"))
        mahasiswaAdapter = mahasiswa_adapter(itemMahasiswa)
        recyclerView.adapter = mahasiswaAdapter
        return next
    }

}