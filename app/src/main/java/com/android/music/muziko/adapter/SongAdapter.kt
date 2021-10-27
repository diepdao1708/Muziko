package com.android.music.ui

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.music.databinding.ItemSongBinding
import com.android.music.muziko.Coordinator
import com.example.kookplayer.utlis.ImageUtils

class SongAdapter(var listSong : ArrayList<Song>,val context: Activity) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {
    var position = 0 // position of current item if click
    inner class SongViewHolder(private var binding: ItemSongBinding): RecyclerView.ViewHolder(binding.root){
        var title = binding.txtTitle
        var artist = binding.txtArtist
        var imageSong = binding.imgSong
        //var menuBtn = binding.musicMenuBtn
        fun bind(song:Song){
            title.text = song.title
            artist.text = song.artist
            song.image?.let {
                ImageUtils.loadImageToImageView(
                    context = context,
                    imageView = imageSong,
                    image = it
                )
            }
        }
        fun onClickItem(){
            binding.songContainer.setOnClickListener{
                upDatePosition(adapterPosition)
                Coordinator.sourceOfSelectedSong = "songs"
                Coordinator.currentDataSource = listSong
                Coordinator.playSelectedSong(listSong[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongAdapter.SongViewHolder {
        var binding = ItemSongBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SongViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongAdapter.SongViewHolder, position: Int) {
        val song = listSong[position]
        this.position = position
        holder.apply {
            bind(song)
            onClickItem()
        }
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

    fun upDatePosition(newPosition: Int){
        position = newPosition
    }

    fun getCurrentPosition():Int{
        return position
    }
}