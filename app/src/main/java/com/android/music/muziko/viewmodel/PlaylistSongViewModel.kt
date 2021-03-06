package com.android.music.muziko.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.music.muziko.repository.PlaylistSongRepository
import com.android.music.muziko.model.Song

class PlaylistSongViewModel : ViewModel(){

    var dataset: MutableLiveData<ArrayList<Any>> = MutableLiveData()
    lateinit var playlistSongRepository: PlaylistSongRepository
    private var playlistId: String = ""

    init {
        dataset.value = ArrayList()
    }

    fun setPlaylistId(pId: String, array: ArrayList<Song>)
    {
        playlistId = pId
        playlistSongRepository = PlaylistSongRepository(playlistId, array)
        updateDataset()
    }

    fun updateDataset() {
        dataset.value = playlistSongRepository.getSongs() as ArrayList<Any>
    }

    fun getDataset(): ArrayList<Song> {
        return dataset.value as ArrayList<Song>
    }

    fun removeSongFromPlaylist(songId: String){
        playlistSongRepository.removeSongFromPlaylist(songId)
        updateDataset()
    }
}