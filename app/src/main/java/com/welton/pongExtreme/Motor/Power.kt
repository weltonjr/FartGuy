package com.welton.pongExtreme.Motor

import com.silvano.AndGraph.AGSprite


abstract class Power(
        name: String,
        sprite: AGSprite
){
    var name = name
    var sprite = sprite
    abstract fun use()
}