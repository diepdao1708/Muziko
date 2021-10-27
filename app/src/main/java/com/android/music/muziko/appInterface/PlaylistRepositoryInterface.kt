package com.android.music.muziko.appInterface

import com.android.music.muziko.model.Playlist

interface PlaylistRepositoryInterface {

    fun createPlaylist(name: String)

    fun getPlaylists(): ArrayList<Playlist>

    //    fun updateDatabase(): Boolean
    fun removePlaylist(id: Long): Boolean
}