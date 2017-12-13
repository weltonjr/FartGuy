package com.welton.sbbg.engine

import com.silvano.AndGraph.AGSoundManager

/**
 *
 * @param file Nome do arquivo de audio à executar
 * @param delay Tempo minimo para executar novamente o audio em milissegundo
 */
class Audio(file: String, delay:Long){
    private val code = AGSoundManager.vrSoundEffects.loadSoundEffect(file)
    private val timeSync = TimeSync(delay)

    fun play(){
        if(timeSync.check())
            AGSoundManager.vrSoundEffects.play(code)
    }
}