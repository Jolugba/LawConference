package com.example.lawconference.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lawconference.R
import com.example.lawconference.adapter.FavouriteAdapter
import com.example.lawconference.adapter.OnFavouriteItemClickListener
import com.example.lawconference.model.FavouriteList
import com.example.lawconference.util.openActivity
import kotlinx.android.synthetic.main.activity_favourite.*

class FavouriteActivity : AppCompatActivity(),OnFavouriteItemClickListener {

    lateinit var favouriteList: ArrayList<FavouriteList>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)

        favouriteList = ArrayList()
        addFavourite()
        setRecyclerView()


        addFavouriteButton.setOnClickListener {
            openActivity<MainActivity> { }

        }
    }

    private fun setRecyclerView() {
        likeRecyclerView.hasFixedSize()
        likeRecyclerView.layoutManager=LinearLayoutManager(this)
        likeRecyclerView.adapter=FavouriteAdapter(favouriteList,this)
    }

    private fun addFavourite() {
        favouriteList.add(FavouriteList("Lagos,Nigeria","NBA 2019", R.drawable.ic_banking))
        favouriteList.add(FavouriteList("Seoul,South Korea","IBA 2019", R.drawable.ic_litigation))
        favouriteList.add(FavouriteList("Cairo,Egypt","AFBA 2019", R.drawable.ic_banking))

    }
}