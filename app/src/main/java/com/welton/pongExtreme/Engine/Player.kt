package com.welton.pongExtreme.Engine

import com.silvano.AndGraph.*
import com.welton.pongExtreme.R

class Player( game: AGScene, pos: Boolean) : loopInterface {
    val sprite: AGSprite = game.createSprite(R.mipmap.player, 1,1)
    var xPos = 0f
    var yPos = if (pos) 0f else AGScreenManager.iScreenHeight.toFloat()

    fun touch(position: Float){
        yPos = position
    }

    override fun loop(){

        sprite.vrPosition = AGVector2D(xPos, yPos)
    }
}