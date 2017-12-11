package com.welton.pongExtreme.Game

import com.silvano.AndGraph.*
import com.welton.pongExtreme.Engine.Engine


class CenaGame(manager: AGGameManager) : AGScene(manager) {

    override fun init() {
        setSceneBackgroundColor(0f, 0f, 0f)

        //Instancia da Engine
        Engine.instance = Engine(this)


    }

    override fun restart() {

    }

    override fun stop() {

    }


    override fun loop() {

        if (AGInputManager.vrTouchEvents.screenDown()) {
            Engine.instance.touch(AGInputManager.vrTouchEvents.lastPosition.x)
        }

        Engine.instance.loop()
    }

}
