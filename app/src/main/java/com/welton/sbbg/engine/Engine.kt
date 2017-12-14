package com.welton.sbbg.engine

import com.silvano.AndGraph.AGScene
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Singleton do motor do jogo
 */
class Engine(val game: AGScene) : LoopInterface {
    companion object{
        lateinit var instance: Engine
    }
    val player1 = Player(game, down)
    val player2 = Player(game, up)
    var balls = emptyList<Ball>()
    var bricks = emptyList<Brick>()
    var lifes = 3   //Não importa atualmente

    val quote = "A maior diferença entre uma coisa que pode pifar e uma coisa que não pode pifar de jeito nenhum. " +
                "É que uma coisa que quando uma coisa que não pode pifar de jeito nenhum pifa, e normalmente impossivel concertar-las"

    /**
     * Metodo de Loop da Engine, executa
     */
    override fun loop(){
        //Executa os metodos loop
        player1.loop()
        player2.loop()
        balls.loop()

        //Limpa as listas
        balls = balls.clearOutOfBounds()
        bricks = bricks.clearKilled()

        checkBalls()
    }

    /**
     * Chama o metodo touch() dos Players
     */
    fun touch(position: Float){
        player1.touch(position)
        player2.touch(position)
    }

    /**
     * Testa se existem Tijolos no jogo, ignorando os Tijolos imortais
     */
    fun hasBricks():Boolean{
        bricks.forEach{
            if(!it.imortal) return true
        }
        return false
    }

    /**
     * Testa se ainda existem Bolas no jogo, se não reduz uma vida e adiciona uma nova Bola
     */
    fun checkBalls(){
        if(balls.isEmpty()){
            lifes--
            balls += Ball()
        }
    }

    fun loadLevel(data:InputStream){
        val inputReader = InputStreamReader(data)
        val bufferedReader = BufferedReader(inputReader)

        var lin = 5
        var col = 1

        try {
            var line = bufferedReader.readLine()
            while (line != null) {

                for(item in line){
                    if(item!=' ')
                        bricks += item.toBrick(col, lin)
                    col++
                }
                lin--; col = 1

                line = bufferedReader.readLine()
            }
        } catch (e: Exception) {

        }
    }
}

//Constantes de (direção => booleano) para referencia apenas
val up = false
val down = true
val left = false
val right = true