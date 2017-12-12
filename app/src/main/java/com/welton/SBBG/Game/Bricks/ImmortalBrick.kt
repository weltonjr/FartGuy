package com.welton.SBBG.Game.Bricks

import com.welton.SBBG.Engine.Brick
import com.welton.SBBG.Engine.Color
import com.welton.SBBG.R


class ImmortalBrick(x:Int, y:Int): Brick(R.mipmap.brick1, x, y){
    init{
        changeColor(Color(121,85,72))
    }

    override fun collided() {
        //Não faz nada
    }

}
