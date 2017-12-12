package com.welton.pongExtreme.Engine

import com.silvano.AndGraph.AGScreenManager
import com.silvano.AndGraph.AGVector2D

abstract class Brick(spriteImage: Int, x:Int, y:Int){
    val sprite = Engine.instance.game.createSprite(spriteImage, 1, 1)
    var alive = true
    var fadeOutTime = 40

    init {
//        sprite.setScreenPercent(5, 5)

        sprite.vrPosition = AGVector2D(
                (AGScreenManager.iScreenWidth / 10) * x.toFloat(),
                (AGScreenManager.iScreenHeight / 2) + y.toFloat() * 64
        )
    }

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
        if(!alive){
            if(fadeOutTime > 0){
                fadeOutTime--
            }
            else{
//                sprite.release() // esta com bug no metodo
                return false
            }
        }
        return true
    }
}
