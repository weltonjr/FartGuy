package com.welton.sbbg.engine

import com.silvano.AndGraph.AGScreenManager
import com.welton.sbbg.game.bricks.BasicBrick
import com.welton.sbbg.game.bricks.ImmortalBrick


fun List<loopInterface>.loop(){
    for (item in this){
        item.loop()
    }
}

fun List<Brick>.checkCollision(ball: Ball): Boolean{
    for (item in this){
        if(item.checkCollision(ball))
            return true
    }
    return false
}

fun List<Brick>.clearKilled(){
    this.filter { it.exist() }
}

fun List<Ball>.clear(){
    this.filter { it.checkAlive() }
}

//Converte valores float para uma proporção da tela atual

fun Float.toHeight(): Float = (this * AGScreenManager.iScreenHeight) / 1920f

fun Float.toWidth(): Float = (this * AGScreenManager.iScreenWidth) / 1080f

fun Char.toBrick(x:Int, y:Int): Brick{
    return when(this){
        '0'  -> ImmortalBrick(x,y)
        '1'  -> BasicBrick(x,y,1)
        '2'  -> BasicBrick(x,y,2)
        '3'  -> BasicBrick(x,y,3)
        '4'  -> BasicBrick(x,y,4)
        '5'  -> BasicBrick(x,y,5)
        '6'  -> BasicBrick(x,y,6)
        '7'  -> BasicBrick(x,y,7)
        '8'  -> BasicBrick(x,y,8)
        '9'  -> BasicBrick(x,y,9)
        else -> BasicBrick(x,y,1)
    }
}