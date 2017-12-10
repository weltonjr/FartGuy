package com.welton.pongExtreme.Game

import com.welton.pongExtreme.Motor.Motor
import com.welton.pongExtreme.Motor.Power
import com.welton.pongExtreme.R


class TestPower: Power(
        "Test",
        Motor.instance.game.createSprite(R.mipmap.btnjogar,1,1)
) {

    override fun use() {
        TODO("not implemented")
    }
}