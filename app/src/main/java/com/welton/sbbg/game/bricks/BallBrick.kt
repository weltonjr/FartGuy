package com.welton.sbbg.game.bricks

import com.welton.sbbg.game.Audios
import com.welton.sbbg.R
import com.welton.sbbg.engine.*

/**
 * Tijolo Especial, aumenta a velocidade da bola
 * @param x Posição X do Tijolo no Grid
 * @param y Posição Y do Tijolo no Grid
 * @param balls Quantidades de Bolas a ser criado, todo(configurar para aceitar mais de 1 nesse parametro)
 */
class BallBrick(x:Int, y:Int, var balls:Int): Brick(R.mipmap.brick3, x, y){
    override val imortal = false

    init {
        changeColor(Color(70,70,255))
    }

    override fun collided(ball:Ball) {
        Audios.hit2.play()
        destroy()
        Engine.instance.balls += Ball()
    }
}
