package com.welton.pongExtreme.Engine

import com.silvano.AndGraph.AGScreenManager
import com.silvano.AndGraph.AGVector2D
import com.welton.pongExtreme.Game.Audios
import com.welton.pongExtreme.R

class Ball : loopInterface {
    val sprite = Engine.instance.game.createSprite(R.mipmap.ball, 1, 1)
    var spriteSize = 64
    private val defaultXSpeed = 0.0f
    private val defaultYSpeed = 10.0f
    var xSpeed = defaultXSpeed / 4
    var ySpeed = defaultYSpeed / 4
    var xDir = Math.random() > 0.5
    var yDir = up
    var yPos = 400f
    var xPos = AGScreenManager.iScreenWidth / 2f


    override fun loop(){
        checkCollision()
        moveY()
        moveX()
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
        yPos += ySpeed .toFloat() * if(yDir) 1 else -1

        if(ySpeed != defaultYSpeed){
            ySpeed -= defaultYSpeed / 120 //Retorna a velocidade a seu valor original

            if(ySpeed < defaultYSpeed)
                ySpeed = defaultYSpeed
        }
    }

    private fun moveX(){
        if(xPos <= spriteSize || xPos >= AGScreenManager.iScreenWidth - spriteSize)
            inverseXDir()

        xPos += xSpeed.toFloat() * if(xDir) 1 else -1

//        if(xSpeed != defaultXSpeed){
//            xSpeed -= defaultXSpeed / 120 //Retorna a velocidade a seu valor original
//
//            if(xSpeed < defaultXSpeed)
//                xSpeed = defaultXSpeed
//        }
    }

    //Inverter direções
    fun inverseYDir(){
        yDir = !yDir
    }

    fun inverseXDir(){
        xDir = !xDir
    }
}
