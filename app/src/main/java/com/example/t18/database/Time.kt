package com.example.t18.database

import java.text.SimpleDateFormat
import java.util.*


fun Long.formatDate ():String{
    val df = SimpleDateFormat("yyyy.MM.dd HH.mm.ss")
    val date = Date(this)
    return df.format(date)

}