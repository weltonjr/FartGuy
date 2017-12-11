package com.welton.pongExtreme.Game

import com.silvano.AndGraph.*
import com.welton.pongExtreme.Engine.Engine


class CenaGame(manager: AGGameManager) : AGScene(manager) {

    override fun init() {
        setSceneBackgroundColor(0f, 0f, 0f)

        //Instancia Engine
        Engine.instance = Engine(this, true)

        //Configurar poderes
//        Engine.instance.powers += TestPower()
//        Engine.instance.powers += TestPower()

    }

    override fun restart() {

    }

    override fun stop() {

    }

    var timer = 0L
    override fun loop() {
        if(System.currentTimeMillis() > timer){
            //Executa algo
            print("Time")

            timer = System.currentTimeMillis() + 2 * 1000 // 2 Segundos a frente
        }


        if (AGInputManager.vrTouchEvents.screenDown()) {
            var flag = true
            for (power in Engine.instance.powers){
                if(power.sprite.collide(AGInputManager.vrTouchEvents.lastPosition)) {
                    power.use()
                    flag = false
                }
            }
            if(flag){
                if (AGInputManager.vrTouchEvents.lastPosition.x > AGScreenManager.iScreenWidth / 2) {
                    Engine.instance.TouchRight()
                }
                else{
                    Engine.instance.TouchLeft()
                }
            }
        }

        //TODO("Receber dados do outro player")

        Engine.instance.loop()
    }

}
