package com.welton.sbbg.engine

import com.silvano.AndGraph.AGScreenManager
import com.silvano.AndGraph.AGVector2D
import com.welton.sbbg.R
import com.welton.sbbg.game.Audios

/**
 * Classe de Bola
 */
class Ball : LoopInterface, ReleaseInterface {
    val sprite = Engine.instance.game.createSprite(R.mipmap.ball, 1, 1)
    val spriteSize = 32f.toWidth()
    private val defaultYSpeed = 15.0f.toHeight()
    var xSpeed = 0f
    var ySpeed = 0f
    var yDir = up
    var yPos = 400f.toHeight()
    var xPos = AGScreenManager.iScreenWidth / 2f

    /**
     * Loop da Bola
     */
    override fun loop(){
        checkCollision()
        moveY(); moveX()//TODO: Mudar logica de movimentação (Um dia(talvez))
        sprite.vrPosition = AGVector2D(xPos, yPos)
    }

    /**
     * Testa se algum player colidiu com a Bola
     */
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
            ySpeed -= defaultYSpeed / 160 //Retorna a velocidade a seu valor original

            if(ySpeed < defaultYSpeed)
                ySpeed = defaultYSpeed
        }
    }

    private fun moveX(){
        if(xPos <= spriteSize || xPos >= AGScreenManager.iScreenWidth - spriteSize) {
            Audios.hit1.play()
            inverseXDir()
        }

        xPos += xSpeed
    }

    /**
     * Testa se a bola está fora da tela
     */
    fun checkOutOfBounds():Boolean = yPos > AGScreenManager.iScreenHeight + 30 || yPos < - 30

    //Inverter direções
    private fun inverseYDir(){
        yDir = !yDir
    }
    private fun inverseXDir(){
        xSpeed = -xSpeed
    }

    /**
     * Implementação do metodo release() da ReleaseInterface
     */
    override fun release(){
        Engine.instance.game.removeSprite(sprite)
        sprite.release()
    }
}
