package com.example.distilleria

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.view.menu.MenuView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class PageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragmentContainer, HomePageFragment())
//            .commit()

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val menu = findViewById<ImageButton>(R.id.imageButton)
        val menuSide = findViewById<NavigationView>(R.id.menu)
        val navController = findNavController(R.id.fragmentContainer)
        menuSide.setupWithNavController(navController)


        menu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }
}