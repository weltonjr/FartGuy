package com.welton.sbbg.engine

class TimeSync(val delay: Long){
    var time = System.currentTimeMillis()

    fun check(): Boolean = time + delay > System.currentTimeMillis()
}
