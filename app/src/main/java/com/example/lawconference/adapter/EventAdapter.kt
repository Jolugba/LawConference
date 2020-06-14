package com.example.lawconference.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lawconference.R
import com.example.lawconference.model.LawEvents
import kotlinx.android.synthetic.main.event_list_view.view.*

class EventAdapter(private var eventList: List<LawEvents>,var clickListener:OnEventItemClickListener): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun initialize(item: LawEvents, action: OnEventItemClickListener) {
            itemView.eventTitle.text = item.eventTitle
            itemView.eventLocation.text = item.eventLocation
            itemView.locationImage.setImageResource(item.image)
            itemView.eventRate.text=item.rating

            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.event_list_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.initialize(eventList[position], clickListener)
    }
}


interface OnEventItemClickListener {
    fun onItemClick(item: LawEvents, position: Int)
}