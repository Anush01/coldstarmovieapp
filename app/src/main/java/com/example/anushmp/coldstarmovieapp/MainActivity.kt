package com.example.anushmp.coldstarmovieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

   lateinit var dwlayout : DrawerLayout
   lateinit var ivmenu : ImageView
   lateinit var drawernav: NavigationView

   lateinit var ivsearch: ImageView

   lateinit var toolbar : androidx.appcompat.widget.Toolbar

   lateinit var botnav: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dwlayout = findViewById(R.id.dwlayout)
        ivmenu = findViewById(R.id.hamburger)
        drawernav = findViewById(R.id.drawernav)
        toolbar = findViewById(R.id.toolbar)
        ivsearch = findViewById(R.id.searchbar)
        botnav = findViewById(R.id.bottomnav)



        //var ji = BottomNavigationView.O

        setSupportActionBar(toolbar)

        var togglee: ActionBarDrawerToggle = ActionBarDrawerToggle(this,dwlayout,R.string.nav_open,R.string.nav_close)

        dwlayout.addDrawerListener(togglee)

        togglee.syncState()

        //dwlayout.openDrawer(drawernav)

        ivmenu.setOnClickListener {

            dwlayout.openDrawer(drawernav)
        }

        //dwlayout.closeDrawer(drawernav)

        //drawernav.visibility = View.INVISIBLE

        //dwlayout.closeDrawer(drawernav)



        ivsearch.setOnClickListener {

            var searchintent : Intent = Intent(this,SearchActivity::class.java)

            startActivity(searchintent)

        }



    }


    override fun onBackPressed() {

        if(dwlayout.isDrawerOpen(GravityCompat.START)){
            dwlayout.closeDrawer(drawernav)
        }else {

            super.onBackPressed()

        }
        }




}