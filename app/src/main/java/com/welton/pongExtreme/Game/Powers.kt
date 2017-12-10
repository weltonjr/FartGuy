package com.welton.pongExtreme.Game

import com.welton.pongExtreme.Engine.Engine
import com.welton.pongExtreme.Engine.Power
import com.welton.pongExtreme.R


class TestPower: Power(
        "Test",
        Engine.instance.game.createSprite(R.mipmap.btnjogar,1,1)
) {

    override fun use() {
        TODO("not implemented")
    }
}