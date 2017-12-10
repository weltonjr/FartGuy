package com.welton.pongExtreme.Engine

import com.silvano.AndGraph.AGScene
import com.silvano.AndGraph.AGScreenManager
import com.silvano.AndGraph.AGVector2D
import com.welton.pongExtreme.R

class Ball(game: AGScene){
    val sprite = game.createSprite(R.mipmap.ball, 1, 1)

    init {
        sprite.vrPosition = AGVector2D(AGScreenManager.iScreenWidth / 2f, AGScreenManager.iScreenHeight / 2f)
    }
}