package com.example.anushmp.coldstarmovieapp

import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class TestViewPagerAdapter(var ImageList: ArrayList<Int>):
    RecyclerView.Adapter<TestViewPagerAdapter.Tvpvh>() {




    inner class Tvpvh(itemView: View) : RecyclerView.ViewHolder(itemView){

        var Img: ImageView = itemView.findViewById(R.id.posterview)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Tvpvh {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.poster_item_view,parent,false)
        var tvpvh: Tvpvh = Tvpvh(view)




        return tvpvh
    }

    override fun onBindViewHolder(holder: Tvpvh, position: Int) {

        holder.Img.setBackgroundResource(ImageList[position])

    }






    override fun getItemCount(): Int {
      return ImageList.size
    }


}