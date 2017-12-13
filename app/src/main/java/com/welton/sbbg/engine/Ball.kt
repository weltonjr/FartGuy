package com.welton.sbbg.engine

import com.silvano.AndGraph.AGScreenManager
import com.silvano.AndGraph.AGVector2D
import com.welton.sbbg.R

class Ball : loopInterface {
    val sprite = Engine.instance.game.createSprite(R.mipmap.ball, 1, 1)
    val spriteSize = 32f.toWidth()
    private val defaultXSpeed = 0.0f
    private val defaultYSpeed = 10.0f.toHeight()
    var xSpeed = defaultXSpeed
    var ySpeed = defaultYSpeed / 4
    var yDir = up
    var yPos = 400f
    var xPos = AGScreenManager.iScreenWidth / 2f


    override fun loop(){
        checkCollision()
        moveY()
        moveX()
        checkAlive()
        sprite.vrPosition = AGVector2D(xPos, yPos)
    }

    private fun checkCollision(){
        Engine.instance.player1.checkCollision(this)
        Engine.instance.player2.checkCollision(this)

        if(Engine.instance.bricks.checkCollision(this)){
            inverseYDir()
        }
    }

    //movimentação
    private fun moveY(){
        yPos += ySpeed * if(yDir) -1 else 1

        if(ySpeed != defaultYSpeed){
            ySpeed -= defaultYSpeed / 120 //Retorna a velocidade a seu valor original

            if(ySpeed < defaultYSpeed)
                ySpeed = defaultYSpeed
        }
    }

    private fun moveX(){
        if(xPos <= spriteSize || xPos >= AGScreenManager.iScreenWidth - spriteSize)
            inverseXDir()

        xPos += xSpeed
    }

    fun checkAlive():Boolean{
        return !(yPos > AGScreenManager.iScreenHeight || yPos < 0)
    }

    //Inverter direções
    fun inverseYDir(){
        yDir = !yDir
    }

    fun inverseXDir(){
        xSpeed = -xSpeed
    }
}
