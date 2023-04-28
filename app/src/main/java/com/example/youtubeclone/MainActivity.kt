package com.example.youtubeclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeclone.data.VideoDetails
import com.example.youtubeclone.databinding.ActivityMainBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding;
    lateinit var adapter: ListAdapter
    var isPlaying = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        lifecycle.addObserver(binding.mainImage)

        binding.mainImage.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "S0Q4gqBUs7c"
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })

        recyclerView()
    }

    private fun recyclerView() {
        val videoList = listOf(
            VideoDetails("part1","talking about motion layout"),
            VideoDetails("part2","talking about motion layout"),
            VideoDetails("part3","talking about motion layout")
        )
        adapter = ListAdapter(videoList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
    }

}
