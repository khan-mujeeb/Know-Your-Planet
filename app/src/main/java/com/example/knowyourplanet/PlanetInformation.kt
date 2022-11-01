package com.example.knowyourplanet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_planet_information.*

class PlanetInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_information)

        window.decorView.apply { systemUiVisibility =
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        var obj = intent.getParcelableExtra<PlanetData>("data")
        var img = intent.getIntExtra("image",-1)

        planet_img.setImageResource(img)
        planet_name.text = obj!!.title.toString()
        planet_galaxy.text = obj!!.galaxy
        planet_distance.text = obj!!.distance
        planet_gravity.text = obj!!.gravity+" m/s²"
        information.text = obj!!.overview

    }
}