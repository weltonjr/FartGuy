package com.welton.sbbg.engine

import com.silvano.AndGraph.AGScreenManager
import com.silvano.AndGraph.AGVector2D

abstract class Brick(spriteImage: Int, x:Int, y:Int){
    val sprite = Engine.instance.game.createSprite(spriteImage, 1, 1)
    var alive = true
    var fadeOutTime = 40

    init {
        sprite.vrPosition = AGVector2D(
                (AGScreenManager.iScreenWidth * 0.1f) * x.toFloat(),
                ((AGScreenManager.iScreenHeight * 0.5f) + y.toFloat() * 64f.toHeight()) + 125f.toHeight()
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

    fun changeColor(color: Color){
        sprite.setColor(color.red, color.green, color.blue)
    }

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
