package com.kuro9.mahjongspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class MahjongSpringApplication(
    private val context: ApplicationContext
) {

//    @PostConstruct
//    fun afterInit() {
//        context.getBean(DiscordListener::class.java)
//    }
}

fun main(args: Array<String>) {
    runApplication<MahjongSpringApplication>(*args)
    // DiscordListener()
}
