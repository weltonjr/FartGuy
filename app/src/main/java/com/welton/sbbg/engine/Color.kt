package com.welton.sbbg.engine


class Color(red:Int, green:Int, blue:Int){
    val red = red / 255f
    val green = green / 255f
    val blue  = blue / 255f
}

object Colors{
    private val livesColor = listOf<Color>(
            Color(255,255,255),   //0 vidas
            Color(255,152,0),   //1 vidas
            Color(205,220,57),   //2 vidas
            Color(76,175,80),   //3 vidas
            Color(0,150,136),   //4 vidas
            Color(0,188,212),   //5 vidas
            Color(63,81,181),   //6 vidas
            Color(156,39,176),   //7 vidas
            Color(245,0,87),   //8 vidas
            Color(213,0,0)    //9 vidas
    )

    infix fun forLive(live: Int): Color = livesColor[live]
}
