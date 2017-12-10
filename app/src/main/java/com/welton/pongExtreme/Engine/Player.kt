package com.welton.pongExtreme.Engine

import com.silvano.AndGraph.*
import com.welton.pongExtreme.R

class Player(game: AGScene, tipo: Boolean){
    val sprite: AGSprite = game.createSprite(R.mipmap.player, 1,1)
    var posX = 0f
    var posY = if (tipo) 0f else AGScreenManager.iScreenHeight.toFloat()
    var speed = 0f

    val speedIncrease = 10f
    val speedDecrease = 1f

    fun touchRight(){
        speed += speedIncrease * (AGInputManager.vrTouchEvents.lastPosition.y / AGScreenManager.iScreenHeight)
    }

    fun touchLeft(){
        speed -= speedIncrease * (AGInputManager.vrTouchEvents.lastPosition.y / AGScreenManager.iScreenHeight)
    }

    fun loop(){
        posX += speed

        //garante que não saia das bordas das telas
        if(posX > AGScreenManager.iScreenWidth) {
            posX = AGScreenManager.iScreenWidth.toFloat()
            speed = 0f
        }
        else if(posX < 0){
            posX = 0f
            speed = 0f
        }

        //reduz a velocidade gradativamente
        if(speed > 0){
            speed -= if(speed - speedDecrease < 0) speed else speedDecrease
        }
        else if(speed < 0){
            speed += if(speed + speedDecrease > 0) speed else speedDecrease
        }

        sprite.vrPosition = AGVector2D(posX, posY)
    }
}