package com.example.kotlinexample1

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class VillagerAdapter (private val dataset:List<Villager>) : RecyclerView.Adapter<VillagerAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val textViewName: TextView = view.findViewById(R.id.textView_name)
        val textViewBirthday: TextView = view.findViewById(R.id.textView_birthday)
        val textViewGreeting: TextView = view.findViewById(R.id.textView_phrase)
        val imageViewVillager: ImageView = view.findViewById(R.id.imageView_villager)

        // onclick here


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_villager, parent, false)
        return ItemViewHolder(adapterLayout)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var villager:Villager = dataset[position]
        holder.textViewName.text = villager.name
        holder.textViewBirthday.text = villager.birthday
        holder.textViewGreeting.text = villager.phrase

        // load in the image
        if (!villager.clicked){
            Picasso.get().load(villager.houseUrl).into(holder.imageViewVillager)
        }
        else{
            Picasso.get().load(villager.villagerUrl).into(holder.imageViewVillager)
        }

        holder.imageViewVillager.setOnClickListener {
            Log.d("click status", villager.clicked.toString())
            if (villager.clicked){
                villager.clicked = false

            }
            else {
                villager.clicked = true
                this.notifyItemChanged(position)

            }
        }


    }
}