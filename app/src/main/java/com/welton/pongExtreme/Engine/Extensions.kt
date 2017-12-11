package com.welton.pongExtreme.Engine


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