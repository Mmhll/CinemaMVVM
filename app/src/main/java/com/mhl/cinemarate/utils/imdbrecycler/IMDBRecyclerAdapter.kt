package com.mhl.cinemarate.utils.imdbrecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mhl.cinemarate.R
import com.mhl.cinemarate.repository.imdb.RatingImdb
import com.mhl.cinemarate.utils.MyItemClickListener

class IMDBRecyclerAdapter(
    private val data: RatingImdb,
    private val context: Context
) :
    RecyclerView.Adapter<IMDBRecyclerAdapter.VH>() {


    private lateinit var myListener: MyItemClickListener

    fun setOnItemClickListener(listener: MyItemClickListener) {
        myListener = listener
    }

    class VH(itemView: View, listener: MyItemClickListener) : RecyclerView.ViewHolder(itemView) {

        //var number : TextView = itemView.findViewById(R.id.recyclerNumber)
        var image: ImageView = itemView.findViewById(R.id.recyclerImage)
        var title: TextView = itemView.findViewById(R.id.recyclerFilmName)
       // var rating : TextView = itemView.findViewById(R.id.recyclerFilmRating)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false),
            myListener
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        Glide.with(context).load(data.items[position].image).centerCrop().into(holder.image)
        holder.title.text = data.items[position].title
        //holder.number.text = (position + 1).toString()
    }

    override fun getItemCount(): Int {
        return data.items.size
    }

}