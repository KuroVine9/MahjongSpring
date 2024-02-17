package com.kuro9.discord

import lombok.extern.slf4j.Slf4j
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Slf4j
@Component
class DiscordListener : ListenerAdapter() {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)
    private val jda: JDA = JDABuilder.createDefault("").build()
    init {
        log.info("DiscordListener init")

        with(jda) {
            presence.setStatus(OnlineStatus.DO_NOT_DISTURB)
            addEventListener(this@DiscordListener)
        }
    }

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        super.onSlashCommandInteraction(event)
    }

}