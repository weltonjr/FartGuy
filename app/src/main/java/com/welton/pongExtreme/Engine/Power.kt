package com.welton.pongExtreme.Engine

import com.silvano.AndGraph.AGSprite


abstract class Power(
        name: String,
        sprite: AGSprite
){
    var name = name
    var sprite = sprite
    abstract fun use()
}