package com.welton.sbbg.engine

/**
 * Usado em classes que executam algo no Loop do Motor
 */
interface LoopInterface {
    fun loop()
}

/**
 * Usado em classes com AGSprites, esse metodo executa o release do sprite
 */
interface ReleaseInterface {
    fun release()
}