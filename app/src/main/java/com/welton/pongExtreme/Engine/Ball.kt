package com.welton.pongExtreme.Engine

import android.util.Log
import com.silvano.AndGraph.AGScene
import com.silvano.AndGraph.AGScreenManager
import com.silvano.AndGraph.AGVector2D
import com.welton.pongExtreme.Game.Audios
import com.welton.pongExtreme.R

class Ball(game: AGScene){
    val sprite = game.createSprite(R.mipmap.ball, 1, 1)
    var spriteSize = 64
    val defaultSpeed = 10.0
    var xSpeed = defaultSpeed
    var ySpeed = defaultSpeed
    var xDir = Math.random() > 0.5
    var yDir = Math.random() > 0.5
    var yPos = AGScreenManager.iScreenHeight / 2f
    var xPos = AGScreenManager.iScreenWidth / 2f


    fun loop(){
        if(Engine.instance.main){
            checkColision()
            moveY()
            moveX()
        }
        sprite.vrPosition = AGVector2D(xPos, yPos)
    }

    private fun checkColision(){
        if(sprite.collide(Engine.instance.player1.sprite)){
            inverseYDir()
        }
        else if(sprite.collide(Engine.instance.player2.sprite)){
            inverseYDir()
        }

        //TODO: remover isto (testes)
        if(yPos > AGScreenManager.iScreenHeight){
            inverseYDir()
        }
    }

    private fun moveY(){
        yPos += ySpeed .toFloat() * if(yDir) 1 else -1

        if(ySpeed != defaultSpeed){
            ySpeed -= defaultSpeed / 20 //Retorna a velocidade a seu valor original

            if(ySpeed < 0)
                ySpeed = defaultSpeed
        }
    }

    private fun moveX(){
        if(xPos <= spriteSize || xPos >= AGScreenManager.iScreenWidth - spriteSize)
            inverseXDir()

        xPos += xSpeed.toFloat() * if(xDir) 1 else -1

        if(xSpeed != defaultSpeed){
            xSpeed -= defaultSpeed / 20 //Retorna a velocidade a seu valor original

            if(xSpeed < 0)
                xSpeed = defaultSpeed
        }
    }

    fun inverseYDir(){
        Audios.bateu.play()
        yDir = !yDir
    }

    fun inverseXDir(){
        xDir = !xDir
    }
}
