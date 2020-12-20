package com.example.t18.database

data class Note(
    var title: String,
    var text: String,
    var time: Long
){
    var id = noteCounter

    companion object{
        var noteCounter = 100
    }

    init {
        noteCounter++
    }

    override fun toString(): String {
        return "\n $id \n $title \n $text \n$time"
    }


}
