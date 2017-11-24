package br.com.hellmets.motocerol.game

import br.com.hellmets.motocerol.AndGraph.AGScreenManager
import br.com.hellmets.motocerol.AndGraph.AGSprite

/**
 * Created by welton.ferreira on 24/11/2017.
 */

class Background(var sprite: AGSprite) {

    init {
        sprite.vrPosition.x = AGScreenManager.iScreenWidth / 2f
        sprite.vrPosition.y = AGScreenManager.iScreenHeight /2f

        sprite.setScreenPercent(100, 100)


    }

    fun loop(){

    }


}