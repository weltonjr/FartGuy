package com.welton.sbbg.engine

import com.silvano.AndGraph.AGSoundManager

class Audio(file: String){
    private val code = AGSoundManager.vrSoundEffects.loadSoundEffect(file)
    private var time = System.currentTimeMillis()

    fun play(){
        if(time < System.currentTimeMillis() + 250)
            AGSoundManager.vrSoundEffects.play(code)
    }
}