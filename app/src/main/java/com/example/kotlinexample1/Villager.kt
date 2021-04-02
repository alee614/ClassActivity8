package com.example.kotlinexample1

// data class ClassName (val x:Type, val y:Type)
data class Villager(val name:String, val birthday:String, val phrase:String,
                    val houseUrl:String, val villagerUrl:String, var clicked:Boolean){
    // keep track of the photo here

// toString
    // Villager(name="Henry", birthday="..", ...)

}


// val -> do not come with setters
// var -> comes with both setter and getter