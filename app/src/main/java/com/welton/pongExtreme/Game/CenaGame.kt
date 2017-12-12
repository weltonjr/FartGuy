package com.welton.pongExtreme.Game

import com.silvano.AndGraph.*
import com.welton.pongExtreme.Engine.Ball
import com.welton.pongExtreme.Engine.Engine


class CenaGame(manager: AGGameManager) : AGScene(manager) {

    override fun init() {
        setSceneBackgroundColor(0f, 0f, 0f)

        //Instancia da Engine
        Engine.instance = Engine(this)

        //Seta alguns parametros do nivel atual
        Engine.instance.balls += Ball()
        Engine.instance.bricks = Level_1()
    }

    override fun restart() {

    }

    override fun stop() {

    }


    override fun loop() {

        Engine.instance.touch(AGInputManager.vrTouchEvents.fPosX)

        Engine.instance.loop()
    }

}
