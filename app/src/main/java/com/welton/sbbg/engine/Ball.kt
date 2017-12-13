package com.welton.sbbg.engine

import com.silvano.AndGraph.AGScreenManager
import com.silvano.AndGraph.AGVector2D
import com.welton.sbbg.R

class Ball : loopInterface {
    val sprite = Engine.instance.game.createSprite(R.mipmap.ball, 1, 1)
    val spriteSize = 32f.toWidth()
    private val defaultXSpeed = 0.0f
    private val defaultYSpeed = 15.0f.toHeight()
    var xSpeed = defaultXSpeed
    var ySpeed = defaultYSpeed / 5
    var yDir = up
    var yPos = 400f
    var xPos = AGScreenManager.iScreenWidth / 2f

    /**
     * Loop da Bola
     */
    override fun loop(){
        checkCollision()
        updateColor()
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

    private fun updateColor(){
        val tmp = ((xSpeed + ySpeed) * 2).toColorFloat()

        sprite.setColor(1f,1f - tmp,1f- tmp)
    }

    fun checkOutOfBounds():Boolean{
        if(yPos > AGScreenManager.iScreenHeight + 30 || yPos < -30) {
            Engine.instance.game.removeSprite(sprite)
            sprite.release()
            return true
        }
        return false
    }

    //Inverter direções
    fun inverseYDir(){
        yDir = !yDir
    }

    fun inverseXDir(){
        xSpeed = -xSpeed
    }
}
