package com.welton.pongExtreme.Game

import com.welton.pongExtreme.Engine.Brick
import com.welton.pongExtreme.R


class BasicBrick(x:Int, y:Int): Brick(R.mipmap.brick1, x, y){

    override fun collided() {
        destroy()
    }

}
