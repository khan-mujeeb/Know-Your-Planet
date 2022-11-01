package com.example.knowyourplanet

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.planet_card_view.view.*

class MyAdapter(var planet: List<PlanetData>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.planet_title
        var planetImg = itemView.planet_img
        var distance = itemView.planet_distance
        var gravity = itemView.planet_gravity
        var galaxy = itemView.planet_galaxy
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.planet_card_view, parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var img: Int? = null
        holder.title.text = planet[position].title
        holder.gravity.text = planet[position].gravity+" m/s²"
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance

//        println(planet[position].title!!.lowercase())
        when (planet[position].title!!.lowercase()) {
            "earth" -> img = R.drawable.earth
            "jupiter" -> img = R.drawable.jupiter
            "mars" -> img = R.drawable.mars
            "mercury" -> img = R.drawable.mercury
            "moon" -> img = R.drawable.moon
            "neptune" -> img = R.drawable.neptune
            "saturn" -> img = R.drawable.saturn
            "sun" -> img = R.drawable.sun
            "uranus" -> img = R.drawable.uranus
            "venus" -> img = R.drawable.venus
        }
//        println("mujeeb $img")
        holder.planetImg.setImageResource(img!!)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlanetInformation::class.java)
            intent.putExtra("data", planet[position])
            intent.putExtra("image", img)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return planet.size
    }
}