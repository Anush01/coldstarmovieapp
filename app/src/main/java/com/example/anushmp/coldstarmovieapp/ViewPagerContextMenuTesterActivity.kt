package com.example.anushmp.coldstarmovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Range
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2

class ViewPagerContextMenuTesterActivity : AppCompatActivity() {


    lateinit var contextbutton: TextView
    lateinit var vp2: ViewPager2

    lateinit var imagelist: ArrayList<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_context_menu_tester)

        contextbutton = findViewById(R.id.contextbutton)
        vp2 = findViewById(R.id.vp2)
        registerForContextMenu(contextbutton)

        imagelist = ArrayList<Int>()

        fillList()

        vp2.adapter = TestViewPagerAdapter(imagelist)



    }

    private fun fillList() {

        var imageid: Int = R.drawable.ic_launcher_background

        var range: IntRange = 1..10

        for(i in range){

            imagelist.add(imageid)

        }

    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?


    ) {
        super.onCreateContextMenu(menu, v, menuInfo)


        menuInflater.inflate(R.menu.item_options_menu,menu)


    }


    override fun onContextItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.item1){

            Toast.makeText(this,"Oh you want to play a movie",Toast.LENGTH_LONG).show()

            return true


        }

        if(item.itemId == R.id.item2){

            Toast.makeText(this,"Oh you want to watch trailers on youtube ", Toast.LENGTH_SHORT).show()

            return true
        }


        //when(item.itemId){
        //
        //    R.id.item1 -> Toast.makeText()
        //
        //}


        return super.onContextItemSelected(item)


    }

}