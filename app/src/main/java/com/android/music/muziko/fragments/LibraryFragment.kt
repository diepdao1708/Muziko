package com.android.music.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.music.R
import com.android.music.ui.SongViewModel

class LibraryFragment : Fragment() {
    companion object{
        const val DELETE_REQUEST_CODE = 2
        lateinit var viewModel: SongViewModel
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }
}