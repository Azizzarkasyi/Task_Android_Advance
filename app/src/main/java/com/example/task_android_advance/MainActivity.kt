package com.example.task_android_advance

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.task_android_advance.databinding.ActivityMainBinding
import com.example.task_android_advance.fragment.home
import com.example.task_android_advance.fragment.list
import com.example.task_android_advance.fragment.setting
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appbar: AppBarLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle
            (this, binding.drawerlayout, binding.appBarLayout, (R.string.Open), (R.string.Close)){

        }
        drawerToggle.isDrawerIndicatorEnabled = true
        binding.drawerlayout.addDrawerListener(drawerToggle)
//        drawerToggle.syncState()

        binding.navbar.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.akun -> reack(Akun())
                R.id.contact -> reack(Akun())
                R.id.help -> reack(Akun())
                else -> {

                }
            }
            true
        }
        repra(home())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_ic -> repra(home())
                R.id.list_ic -> repra(list())
                R.id.setting_ic -> repra(setting())
            }
            true
        }


        binding.appBarLayout.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.logout -> keluar()
            }
            true
        }




    }


    private fun reack(aktifity : Activity) {
        val intent = Intent(this,Akun::class.java)
        startActivity(intent)
    }
    private fun repra(fragment: Fragment){

        val fragmentManager =supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.framelayout,fragment)
        fragmentTransition.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.drawerlayout.closeDrawer(GravityCompat.START)
        return true

    }

    override fun onBackPressed() {
        if (binding.drawerlayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerlayout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }

    }
    fun keluar() {
        val startMain = Intent(Intent.ACTION_MAIN)
        startMain.addCategory(Intent.CATEGORY_HOME)
        startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(startMain)
    }


}