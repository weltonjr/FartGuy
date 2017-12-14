package com.welton.sbbg.game

import com.silvano.AndGraph.*
import com.welton.sbbg.engine.Ball
import com.welton.sbbg.engine.Engine
import com.welton.sbbg.R
import com.welton.sbbg.engine.clearKilled
import com.welton.sbbg.engine.release


class CenaGame(val manager: AGGameManager) : AGScene(manager) {
    var level = 10

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

        Engine.instance.apply {
            if (hasBricks()) {
                touch(AGInputManager.vrTouchEvents.fPosX)
                loop()
            } else {
                level++
                loadLevel()
            }
        }
    }

    /**
     * Carrega o nivel atual na Engine
     */
    private fun loadLevel() {

        Engine.instance.apply { //A Standard.kt é muito foda, como não temos ela em todas as linguagens?

            //Remove os objetos
            balls.release()
            bricks.map { it.destroy() }
            while (bricks.isNotEmpty()) {
                bricks = Engine.instance.bricks.clearKilled()
            }

            //Cria novos objetos
            loadLevel(manager.vrActivity.resources.openRawResource(
                    when (level) {
                        1 -> R.raw.level1
                        2 -> R.raw.level2
                        3 -> R.raw.level3
                        4 -> R.raw.level4
                        5 -> R.raw.level5
                        else -> R.raw.random
                    }))

            balls = listOf(Ball())
        }
    }

}
