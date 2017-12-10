package com.welton.pongExtreme.Game

import com.silvano.AndGraph.*
import com.welton.pongExtreme.Motor.Motor
import com.welton.pongExtreme.R


class CenaGame(manager: AGGameManager) : AGScene(manager) {

    override fun init() {
        setSceneBackgroundColor(0f, 0f, 0f)

        //Instancia Motor
        Motor.instance = Motor(this, true)

        //Configurar poderes
//        Motor.instance.powers += TestPower()
//        Motor.instance.powers += TestPower()

    }

    override fun restart() {

    }

    override fun stop() {

    }

    override fun loop() {
        if (AGInputManager.vrTouchEvents.screenDown()) {
            var flag = true
            for (power in Motor.instance.powers){
                if(power.sprite.collide(AGInputManager.vrTouchEvents.lastPosition)) {
                    power.use()
                    flag = false
                }
            }
            if(flag){
                if (AGInputManager.vrTouchEvents.lastPosition.x > AGScreenManager.iScreenWidth / 2) {
                    Motor.instance.TouchRight()
                }
                else{
                    Motor.instance.TouchLeft()
                }
            }
        }

        //TODO("Receber dados do outro player")

        Motor.instance.loop()
    }
}
