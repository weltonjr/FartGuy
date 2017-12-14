package com.welton.sbbg.game.bricks

import com.welton.sbbg.engine.Brick
import com.welton.sbbg.game.Audios
import com.welton.sbbg.R
import com.welton.sbbg.engine.Ball
import com.welton.sbbg.engine.Color

/**
 * Tijolo Especial, aumenta a velocidade da bola
 * @param x Posição X do Tijolo no Grid
 * @param y Posição Y do Tijolo no Grid
 * @param speed Valor de Incremento na velocidade
 */
class SpeedBrick(x:Int, y:Int, var speed:Float): Brick(R.mipmap.brick2, x, y){
    override val imortal = false

    init {
        changeColor(Color(200,70,70))
    }

    override fun collided(ball:Ball) {
        Audios.hit2.play()
        destroy()
        ball.xSpeed += if(ball.xSpeed < 0) -speed else speed
        ball.ySpeed += speed
    }
}
