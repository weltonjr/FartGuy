package com.welton.pongExtreme.Engine

import com.welton.pongExtreme.R

abstract class Brick : loopInterface{
    val sprite = Engine.instance.game.createSprite(R.mipmap.brick1, 1, 1)
    var alive = true
    val fadeOutTime = 3

    fun checkCollision(ball:Ball): Boolean{
        if(alive && ball.sprite.collide(sprite)){
            collided()
            return true
        }
        return false
    }

    abstract fun collided()

    fun destroy(){
        alive = false
        sprite.fadeOut(fadeOutTime)
    }

    fun exist(): Boolean{
        if(!alive && sprite.fadeEnded()){
            sprite.release()
            return true
        }
        return false
    }
}
