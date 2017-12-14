package com.welton.sbbg.engine

import com.silvano.AndGraph.AGScreenManager
import com.welton.sbbg.game.bricks.BallBrick
import com.welton.sbbg.game.bricks.BasicBrick
import com.welton.sbbg.game.bricks.ImmortalBrick
import com.welton.sbbg.game.bricks.SpeedBrick


/**
 * Executa o metodo Loop() de cada item da lista
 */
fun List<LoopInterface>.loop() = this.forEach{ it.loop()}

/**
 * Checa se houve colisão da Bola com qualquer Tijolo da lista
 */
fun List<Brick>.checkCollision(ball: Ball): Boolean{
    this.forEach {
        if (it.checkCollision(ball))
            return true
    }
    return false
}

/**
 * Elimina da lista os Tijolos que já sairam da tela
 */
fun List<Brick>.clearKilled():List<Brick> = this.filter { it.exist() }

/**
 * Elimina as Bolas que sairam da tela
 */
fun List<Ball>.clearOutOfBounds(): List<Ball> = this.filter { it.checkOutOfBounds().not() }

/**
 * Executa o metodo Release() dos itens da lista
 */
fun List<ReleaseInterface>.release() = this.forEach { it.release() }

//Converte valores float para uma proporção da tela atual
fun Float.toHeight(): Float = (this * AGScreenManager.iScreenHeight) / 1920f

fun Float.toWidth(): Float = (this * AGScreenManager.iScreenWidth) / 1080f


/**
 * Converte Char para um Tijolo correspondente ao valor do Char
 */
fun Char.toBrick(x:Int, y:Int): Brick{
    return when(this){
        'X'  -> ImmortalBrick(x,y)
        '0'  -> BasicBrick(x,y,0)
        '1'  -> BasicBrick(x,y,1)
        '2'  -> BasicBrick(x,y,2)
        '3'  -> BasicBrick(x,y,3)
        '4'  -> BasicBrick(x,y,4)
        '5'  -> BasicBrick(x,y,5)
        '6'  -> BasicBrick(x,y,6)
        '7'  -> BasicBrick(x,y,7)
        '8'  -> BasicBrick(x,y,8)
        '9'  -> BasicBrick(x,y,9)
        'S'  -> SpeedBrick(x,y,6f)
        'B'  -> BallBrick(x,y,1)
        'R'  -> randomBrick(x,y)
        else -> BasicBrick(x,y,0)
    }
}


//Cria um Tijolo Aleatorio
fun randomBrick(x:Int, y:Int): Brick{
    val rand = Math.random()
    return when{
        rand < .1 -> BasicBrick(x,y, 1)
        rand < .2 -> BasicBrick(x,y, 2)
        rand < .3 -> BasicBrick(x,y, 3)
        rand < .4 -> ImmortalBrick(x,y)
        rand < .5 -> BallBrick(x,y,1)
        rand < .6 -> BallBrick(x,y,1)
        rand < .7 -> SpeedBrick(x,y,6f)
        rand < .8 -> SpeedBrick(x,y,6f)
        rand < .9 -> BasicBrick(x,y, 4)
        else -> randomBrick(x,y)
    }
}

