package com.example.youtubeclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.youtubeclone.data.VideoDetails
import com.example.youtubeclone.databinding.ListItemBinding

class ListAdapter(private val videoList: List<VideoDetails>) :
    RecyclerView.Adapter<ListAdapter.ListHolder>() {

    class ListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, null, false)
        )
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val currentVideo = videoList[position]
        holder.binding.videTitle.text = currentVideo.title
        holder.binding.videSubTitle.text = currentVideo.sub_title
    }

    override fun getItemCount(): Int {
        return videoList.size
    }
}
