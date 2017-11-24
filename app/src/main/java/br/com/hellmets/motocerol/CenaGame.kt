package br.com.hellmets.motocerol

import br.com.hellmets.motocerol.AndGraph.AGGameManager
import br.com.hellmets.motocerol.AndGraph.AGScene
import br.com.hellmets.motocerol.AndGraph.AGScreenManager
import br.com.hellmets.motocerol.AndGraph.AGSprite
import br.com.hellmets.motocerol.game.Background


class CenaGame(manager: AGGameManager) : AGScene(manager) {
    private lateinit var background: Background


    override fun init() {
        setSceneBackgroundColor(0f, 0.75f, 0f)

        background = Background(this.createSprite(R.mipmap.background, 1, 1))




    }

    override fun restart() {

    }

    override fun stop() {

    }

    override fun loop() {

    }
}
