package com.kuro9.mahjongspring

import com.kuro9.discord.DiscordListener
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MahjongSpringApplication

fun main(args: Array<String>) {
    runApplication<MahjongSpringApplication>(*args)
    DiscordListener()
}
