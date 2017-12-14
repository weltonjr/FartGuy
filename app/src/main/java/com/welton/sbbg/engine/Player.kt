package com.welton.sbbg.engine

import com.silvano.AndGraph.*
import com.welton.sbbg.game.Audios
import com.welton.sbbg.R

/**
 * Esta classe cria e controla um player na tela
 *
 * @param side O local na tela que o player vai ficar (up = false, down = true)
 */
class Player( game: AGScene, val side: Boolean) : LoopInterface {
    val sprite: AGSprite = game.createSprite(R.mipmap.player, 1,1)
    private var xPos = 0f
    private var xTarget = 0f
    private val xSpeed = 50f.toWidth()
    private var yPos = if (side) 250f.toHeight() else AGScreenManager.iScreenHeight.toFloat() - 50

    /**
     *  Atualiza a posição desejada para o player, (não sua real posição)
     *  @param position Posição na tela, em pixels
     */
    fun touch(position: Float){
        xTarget = if (position > 64f.toWidth()){
            if(position < AGScreenManager.iScreenWidth - 64f.toWidth()){
                position
            }
            else{
                AGScreenManager.iScreenWidth - 64f.toWidth()
            }
        }
        else{
            64f.toWidth()
        }
    }

    /**
     *  Testa se o player colidiu com uma determinada Bola, e atualiza a velocidade da bola
     *  @param ball Objeto Bola para testar a colisão
     */
    fun checkCollision(ball :Ball) {
        if(ball.sprite.collide(sprite)) {
            Audios.hit1.play()

            ball.yDir = !side

            //muda a velocidade da bola dependendo do local da colisão
            val speed = (ball.xPos - xPos) / 20

            ball.xSpeed += speed
            ball.ySpeed += (if(speed>0) speed else (-speed)) * 0.4f
        }
    }

    /**
     * Atualiza a posição x do Player baseado em sua velocidade maxima
     */
    private fun moveX(){
        if(xTarget > xPos){
            xPos = if(xPos + xSpeed < xTarget) xPos + xSpeed else xTarget
        }
        else if(xTarget < xPos){
            xPos = if(xPos - xSpeed > xTarget) xPos - xSpeed else xTarget
        }
    }

    /**
     * Loop do Player
     */
    override fun loop(){
        moveX()
        sprite.vrPosition = AGVector2D(xPos, yPos)
    }
}
