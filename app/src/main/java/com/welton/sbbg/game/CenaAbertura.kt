package com.welton.sbbg.game

import com.silvano.AndGraph.AGGameManager
import com.silvano.AndGraph.AGInputManager
import com.silvano.AndGraph.AGScene
import com.silvano.AndGraph.AGSprite
import com.silvano.AndGraph.AGScreenManager

import com.welton.sbbg.R

class CenaAbertura(manager: AGGameManager) : AGScene(manager) {
    private var botao: AGSprite? = null

    override fun init() {
        setSceneBackgroundColor(1f, 1f, 1f)

        botao = this.createSprite(R.mipmap.play2, 2, 1)
        botao?.setScreenPercent(55, 15)

        //Altura e Largura
        botao?.vrPosition?.x = (AGScreenManager.iScreenWidth / 2).toFloat()
        botao?.vrPosition?.y = (AGScreenManager.iScreenHeight / 2).toFloat()
    }

    override fun restart() {

    }

    override fun stop() {

    }

    override fun loop() {
        if (AGInputManager.vrTouchEvents.screenClicked()) {
            if (botao!!.collide(AGInputManager.vrTouchEvents.lastPosition)) {
                this.vrGameManager.setCurrentScene(1)
            }
        }
    }
}
