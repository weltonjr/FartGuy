package com.welton.SBBG.Game.Bricks

import com.welton.SBBG.Engine.Brick
import com.welton.SBBG.Engine.Color
import com.welton.SBBG.R


class BasicBrick(x:Int, y:Int, var lives:Int): Brick(R.mipmap.brick1, x, y){
    companion object color{
        val withLive = listOf<Color>(
                Color(255,255,255),   //0 vidas
                Color(255,255,255),   //1 vidas
                Color(255,235,59),   //2 vidas
                Color(255,193,7),   //3 vidas
                Color(255,152,0),   //4 vidas
                Color(255,87,34),   //5 vidas
                Color(3,169,244),   //6 vidas
                Color(33,150,243),   //7 vidas
                Color(0,188,212),   //8 vidas
                Color(0,150,136)    //9 vidas
                )
    }

    init {
        changeColor(BasicBrick.color.withLive[lives])
    }

    override fun collided() {
        lives--

        if (lives <= 0){
            destroy()
        }
        else{
            changeColor(BasicBrick.color.withLive[lives])
        }
    }
}
