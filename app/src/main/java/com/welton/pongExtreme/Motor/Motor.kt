package com.welton.pongExtreme.Motor

import com.silvano.AndGraph.AGScene
import com.silvano.AndGraph.AGSprite
import com.welton.pongExtreme.Game.TestPower

class Motor(game: AGScene, main:Boolean){
    companion object {
        lateinit var instance:Motor
    }
    val game = game
    val main = main
    val player1 = Player(game, main)
    val player2 = Player(game, !main)
    val ball = Ball(game)

    var powers = emptyList<Power>()

    fun TouchRight(){
        (if(main) player1 else player2).touchRight()
    }

    fun TouchLeft(){
        (if(main) player1 else player2).touchLeft()
    }

    fun loop(){
        player1.loop()
        player2.loop()
        //TODO("Loop Bola")
    }
}
