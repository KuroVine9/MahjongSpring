package com.kuro9.discord

import lombok.extern.slf4j.Slf4j
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent
import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.events.session.ShutdownEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.components.buttons.Button
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.lang.String


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
        when (event.getFullCommandName()) {
            "ping" -> {}

            "revalid" -> {}
            "file" -> {}

            "add" -> {}
            "stat season" -> {}
            "stat month" -> {}
            "stat entire" -> {}
            "rank entire" -> {}

            "rank month" -> {}

            "rank season" -> {}

            "machi" -> {}
            "admin add" -> {}
            "admin get" -> {}
            "admin delete" -> {}
            "game_group add" -> {}
            "game_group get" -> {}
            "delete" -> {}
            "modify" -> {}
            else -> {}
        }
    }

    override fun onButtonInteraction(event: ButtonInteractionEvent) {
        val buttonId = event.componentId
    }

    override fun onReady(event: ReadyEvent) {
        log.info("DiscordListener onReady")
    }

    override fun onShutdown(event: ShutdownEvent) {
        log.info("DiscordListener onShutdown")
    }

}