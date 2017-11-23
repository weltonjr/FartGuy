package br.com.hellmets.motocerol

import br.com.hellmets.motocerol.AndGraph.AGGameManager
import br.com.hellmets.motocerol.AndGraph.AGScene
import br.com.hellmets.motocerol.AndGraph.AGScreenManager
import br.com.hellmets.motocerol.AndGraph.AGSprite


class CenaMenu(manager: AGGameManager) : AGScene(manager) {
    internal var gato: AGSprite? = null

    override fun init() {
        /*carta = this.createSprite(R.mipmap.versocarta, 1,1);
        carta.setScreenPercent(50,50);

        //Altura e Largura
        carta.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        carta.vrPosition.setY(AGScreenManager.iScreenHeight/2);*/

        gato = this.createSprite(R.mipmap.cat, 2, 4)
        gato?.setScreenPercent(25, 20)

        //Altura e Largura
        gato?.vrPosition?.x = (AGScreenManager.iScreenWidth / 3).toFloat()
        gato?.vrPosition?.y = (AGScreenManager.iScreenHeight / 2).toFloat()



        gato?.addAnimation(10, true, 0, 7)


        setSceneBackgroundColor(0f, 0.75f, 0f)
    }

    override fun restart() {

    }

    override fun stop() {

    }

    override fun loop() {

    }
}
