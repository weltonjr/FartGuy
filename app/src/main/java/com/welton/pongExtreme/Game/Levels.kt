package com.welton.pongExtreme.Game

import com.welton.pongExtreme.Engine.Brick

fun Level_1(): List<Brick> {
    var bricks = emptyList<Brick>()

    bricks += BasicBrick(1,0)
    bricks += BasicBrick(2,0)
    bricks += BasicBrick(3,0)
    bricks += BasicBrick(4,0)
    bricks += BasicBrick(5,0)
    bricks += BasicBrick(6,0)
    bricks += BasicBrick(7,0)
    bricks += BasicBrick(8,0)
    bricks += BasicBrick(9,0)
    bricks += BasicBrick(3,1)

    bricks += BasicBrick(3,3)

    bricks += BasicBrick(3,-2)

    return bricks
}
