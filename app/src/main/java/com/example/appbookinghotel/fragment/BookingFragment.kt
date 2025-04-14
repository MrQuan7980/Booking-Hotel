package com.example.appbookinghotel.fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appbookinghotel.R
import com.example.appbookinghotel.databinding.FragmentBookingBinding

class BookingFragment : Fragment() {
    private lateinit var binding : FragmentBookingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookingBinding.inflate(inflater, container,false);

        initVideo()

        return binding.root
    }
    private fun initVideo()
    {
        val videoPath = "android.resource://" + context?.packageName + "/" + R.raw.video
        binding.videoIntro.setVideoURI(Uri.parse(videoPath))
        binding.videoIntro.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
            binding.videoIntro.start()
        }
    }
    private fun initPriceLevel()
    {

    }
}