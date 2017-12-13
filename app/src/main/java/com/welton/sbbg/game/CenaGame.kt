package com.welton.sbbg.game

import com.silvano.AndGraph.*
import com.welton.sbbg.engine.Ball
import com.welton.sbbg.engine.Engine
import com.welton.sbbg.R


class CenaGame(val manager: AGGameManager) : AGScene(manager) {
    var level = 1

    override fun init() {
        setSceneBackgroundColor(0f, 0f, 0f)

        //Instancia da Engine
        Engine.instance = Engine(this)

        //Seta alguns parametros do nivel atual
        Engine.instance.balls += Ball()

        if(level == 1)
            Engine.instance.loadLevel(manager.vrActivity.resources.openRawResource(R.raw.level1))

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