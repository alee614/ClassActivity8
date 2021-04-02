package com.example.kotlinexample1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinexample1.databinding.ActivityThirdBinding
import org.json.JSONObject

class ThirdActivity : AppCompatActivity() {
    private lateinit var villagersList:ArrayList<Villager>
    private lateinit var binding:ActivityThirdBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerViewVillagers

        villagersList = ArrayList<Villager>()

        val jsonContent = loadJSONfromAssets("villagers.json")
        val jsonObject = JSONObject(jsonContent)

        val jsonArray = jsonObject.getJSONArray("villagers")
        Log.e("length of file", jsonArray.length().toString())

        // keywords: in and until
        for (i in 0 until jsonArray.length()){
            val villagerJSONObject = jsonArray.getJSONObject(i)
           // extract name, birthday, phrase
            val name:String = villagerJSONObject.get("name").toString()
            val birthday:String = villagerJSONObject.get("birthday").toString()
            val phrase:String = villagerJSONObject.get("phrase").toString()
            val houseUrl:String = villagerJSONObject.get("house").toString()
            val villagerUrl:String = villagerJSONObject.get("villager").toString()

            val villagerObject:Villager = Villager(name, birthday, phrase, houseUrl, villagerUrl, false)
            villagersList.add(villagerObject)
        }

        recyclerView.adapter = VillagerAdapter(villagersList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
            // read in the json file
            // create an arraylist of villagers
        // create the adatper with the slit of villagers
        // set it to the recyclerview

    }

    private fun loadJSONfromAssets(filename:String):String{
        return applicationContext.assets.open(filename).bufferedReader().use {it.readText()} }
}