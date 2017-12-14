package com.welton.sbbg.game.bricks

import com.welton.sbbg.engine.Brick
import com.welton.sbbg.game.Audios
import com.welton.sbbg.R
import com.welton.sbbg.engine.Ball
import com.welton.sbbg.engine.Colors

/**
 * Tijolo Basico, com cores que mudam dependendo da quantidade de vidas
 * @param x Posição X do Tijolo no Grid
 * @param y Posição Y do Tijolo no Grid
 * @param lives Vidas do Tijolo
 */
class BasicBrick(x:Int, y:Int, var lives:Int): Brick(R.mipmap.brick1, x, y){
    override val imortal = false

    init {
        changeColor(Colors forLive lives)
    }

    override fun collided(ball: Ball) {
        Audios.hit1.play()

        lives--

        if (lives <= 0){
            destroy()
        }
        else{
            changeColor(Colors forLive lives)
        }
    }
}
