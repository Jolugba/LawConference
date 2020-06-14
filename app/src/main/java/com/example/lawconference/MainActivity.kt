package com.example.lawconference

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.lawconference.adapter.EventAdapter
import com.example.lawconference.adapter.OnEventItemClickListener
import com.example.lawconference.databinding.ActivityMainBinding
import com.example.lawconference.model.LawEvents
import com.example.lawconference.ui.EventDetailActivity
import com.example.lawconference.ui.FavouriteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnEventItemClickListener {

    lateinit var binding:ActivityMainBinding
    lateinit var eventList: ArrayList<LawEvents>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)


        eventList= ArrayList()
        addEvents()
        setRecyclerView()

        binding.favouriteButton.setOnClickListener {
            val intent = Intent(this, FavouriteActivity::class.java)
            startActivity(intent)
        }

    }



    private fun addEvents() {
        eventList.add(LawEvents(getString(R.string.event_1_location),getString(R.string.event_1_name),"4.8",R.drawable.lagos_location))
        eventList.add(LawEvents(getString(R.string.event_2_location),getString(R.string.event_2_name),"4.9",R.drawable.seoul_location))
        eventList.add(LawEvents(getString(R.string.event_3_location),getString(R.string.event_3_name),"4.5",R.drawable.cairo_location))
        eventList.add(LawEvents(getString(R.string.event_4_location),getString(R.string.event_4_name),"4.8",R.drawable.uk_location))

    }
    private fun setRecyclerView() {
        var  spansCount=resources.getInteger(R.integer.spans_column)
        recyclerView.layoutManager= StaggeredGridLayoutManager(spansCount,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter=EventAdapter(eventList,this)


    }

    override fun onItemClick(item: LawEvents, position: Int) {
        val intent = Intent(this, EventDetailActivity::class.java)
        intent.putExtra("itemTitle", item.eventTitle)
        intent.putExtra("itemLocation", item.eventLocation)
        intent.putExtra("itemRating", item.rating)
        intent.putExtra("itemImage", item.image.toString())
        startActivity(intent)
    }
}