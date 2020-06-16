package com.example.lawconference.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lawconference.R
import com.example.lawconference.model.FavouriteList
import kotlinx.android.synthetic.main.favourite_list_view.view.*

class FavouriteAdapter(
    private var favouriteList: List<FavouriteList>,
    var clickListener:OnFavouriteItemClickListener
) : RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>() {


    inner class FavouriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun initialize(item: FavouriteList, action: OnFavouriteItemClickListener) {
            itemView.favouriteTitle.text = item.eventTitle
            itemView.favouriteLocation.text = item.eventLocation
            itemView.favouriteimage.setImageResource(item.image)




            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        return FavouriteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.favourite_list_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return favouriteList.size
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.initialize(favouriteList[position], clickListener)


    }
}


interface OnFavouriteItemClickListener {
    fun onItemClick(item: FavouriteList, position: Int) {
    }
}