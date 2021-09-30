package com.example.anushmp.coldstarmovieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PosterAdapter(var urlList:ArrayList<String>, var titleList:ArrayList<String>, var clicker: Clicker):RecyclerView.Adapter<PosterAdapter.PosterVh>() {






    inner class PosterVh(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{


    var posterview: ImageView = itemView.findViewById(R.id.posterview)

        fun setdata(url:String){



            Glide.with(itemView).load(url).placeholder(R.drawable.ic_launcher_foreground).into(posterview)


            posterview.setOnClickListener(this)



        }

        override fun onClick(v: View?) {
            clicker.whenclicked(adapterPosition)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterVh {

        var v : View = LayoutInflater.from(parent.context).inflate(R.layout.poster_item_view,parent,false)

        var pvh = PosterVh(v)

        return pvh

    }

    override fun onBindViewHolder(holder: PosterVh, position: Int) {
        holder.setdata(urlList[position])
    }

    override fun getItemCount(): Int {
        return urlList.size
    }

}