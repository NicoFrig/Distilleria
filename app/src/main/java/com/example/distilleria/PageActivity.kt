package com.example.distilleria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class PageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_home_page, HomePageFragment())
            .commit()

        var drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        var menu = findViewById<ImageButton>(R.id.imageButton)

        menu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }
}