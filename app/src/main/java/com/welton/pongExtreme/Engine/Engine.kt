package com.welton.pongExtreme.Engine

import com.silvano.AndGraph.AGScene

class Engine( game: AGScene) : loopInterface{
    companion object{
        lateinit var instance: Engine
    }
    val game = game
    val player1 = Player(game, down)
    val player2 = Player(game, up)
    var balls = emptyList<Ball>()
    var bricks = emptyList<Brick>()

    val quote = "A maior diferença entre uma coisa que pode pifar e uma coisa que não pode pifar de jeito nenhum. " +
                "É que uma coisa que quando uma coisa que não pode pifar de jeito nenhum pifa, e normalmente impossivel concertar-las"

    override fun loop(){
        player1.loop()
        player2.loop()
        balls.loop()
        bricks.clearKilled()
    }

    fun touch(position: Float){
        player1.touch(position)
        player2.touch(position)
    }
}

//Constantes de direção => booleano para referencia apenas
val up = false
val down = true
val left = false
val right = true