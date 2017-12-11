package com.welton.pongExtreme.Engine

import com.silvano.AndGraph.AGSoundManager

class Audio(file: String){
    private val code = AGSoundManager.vrSoundEffects.loadSoundEffect(file)

    fun play(){
        AGSoundManager.vrSoundEffects.play(code)
    }
}