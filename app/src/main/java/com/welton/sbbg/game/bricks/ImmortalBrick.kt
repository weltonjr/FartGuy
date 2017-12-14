package com.welton.sbbg.game.bricks

import com.welton.sbbg.engine.Brick
import com.welton.sbbg.engine.Color
import com.welton.sbbg.R
import com.welton.sbbg.engine.Ball


class ImmortalBrick(x:Int, y:Int): Brick(R.mipmap.brick1, x, y){
    override val imortal = true
    init{
        changeColor(Color(121,85,72))
    }

    override fun collided(ball:Ball) {
        //Não faz nada
    }

}
