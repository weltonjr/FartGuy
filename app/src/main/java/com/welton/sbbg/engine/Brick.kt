package com.welton.sbbg.engine

import com.silvano.AndGraph.AGScreenManager
import com.silvano.AndGraph.AGVector2D

abstract class Brick(spriteImage: Int, x:Int, y:Int){
    val sprite = Engine.instance.game.createSprite(spriteImage, 1, 1)
    var alive = true
    var fadeOutTime = 40
    var timeSync = TimeSync(200)
    abstract val imortal: Boolean

    init {
        sprite.vrPosition = AGVector2D(
                (AGScreenManager.iScreenWidth * 0.1f) * x.toFloat(),
                ((AGScreenManager.iScreenHeight * 0.5f) + y.toFloat() * 64f.toHeight()) + 125f.toHeight()
        )
    }

    fun checkCollision(ball:Ball): Boolean{
        if(alive && ball.sprite.collide(sprite) && timeSync.check()){
            collided()
            return true
        }
        return false
    }

    abstract fun collided()

    fun changeColor(color: Color){
        sprite.setColor(color.red, color.green, color.blue)
    }

    /**
     * Remove o estado de vivo do Tijolo e inicia a animação de desaparecer
     */
    fun destroy(){
        alive = false
        sprite.fadeOut(fadeOutTime)
    }

    fun exist(): Boolean{
        if(!alive){
            if(fadeOutTime > 0){    //Testa se o sprite já sumiu da tela
                fadeOutTime--
            }
            else{
                //Elimina o sprite e libera recursos
                Engine.instance.game.removeSprite(sprite)
                sprite.release()
                return false
            }
        }
        return true
    }
}
