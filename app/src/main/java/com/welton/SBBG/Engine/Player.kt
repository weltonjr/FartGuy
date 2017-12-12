package com.welton.SBBG.Engine

import com.silvano.AndGraph.*
import com.welton.SBBG.R

class Player( game: AGScene, val side: Boolean) : loopInterface {
    val sprite: AGSprite = game.createSprite(R.mipmap.player, 1,1)
    var xPos = 0f
    var xTarget = 0f
    val xSpeed = 50f.toWidth()
    var yPos = if (side) 250f.toHeight() else AGScreenManager.iScreenHeight.toFloat() - 50

    fun touch(position: Float){
        xTarget = position
    }

    fun checkCollision(ball :Ball) {
        if(ball.sprite.collide(sprite)) {
            ball.yDir = !side

            //muda a direção da bola dependendo do local da colisão
            val speed = (ball.xPos - xPos) / 20


            ball.xSpeed += speed
            ball.ySpeed += (if(speed>0) speed else (-speed)) * 0.4f
        }
    }

    fun moveX(){
        if(xTarget > xPos){
            xPos = if(xPos + xSpeed < xTarget) xPos + xSpeed else xTarget
        }
        else if(xTarget < xPos){
            xPos = if(xPos - xSpeed > xTarget) xPos - xSpeed else xTarget
        }
    }

    override fun loop(){
        moveX()
        sprite.vrPosition = AGVector2D(xPos, yPos)
    }
}
