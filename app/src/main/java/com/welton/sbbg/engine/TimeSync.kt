package com.welton.sbbg.engine

/**
 *  Usado para sincronizar ações com o tempo real do jogo
 *  @param delay Tempo em milissegundo entre cada execução
 */
class TimeSync(val delay: Long) {
    var time = System.currentTimeMillis()

    /**
     * Testa se já se passou o delay entre a ultima chamada do metodo e agora
     */
    fun check(): Boolean {
        val total = time + delay
        time = System.currentTimeMillis()

        return  total < time
    }
}
