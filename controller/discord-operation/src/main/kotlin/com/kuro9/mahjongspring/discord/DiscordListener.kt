package com.kuro9.mahjongspring.discord

import com.kuro9.mahjongspring.discord.enumurate.SlashCommand
import jakarta.annotation.PostConstruct
import lombok.extern.slf4j.Slf4j
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent
import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.events.session.ShutdownEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Slf4j
@Component
class DiscordListener : ListenerAdapter() {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)
    private val jda: JDA = JDABuilder.createDefault("").build()

    @PostConstruct
    fun init() {
        log.info("DiscordListener init")

        with(jda) {
            presence.setStatus(OnlineStatus.DO_NOT_DISTURB)
            addEventListener(this@DiscordListener)
        }
    }

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        when (SlashCommand.toSlashCommand(event.fullCommandName)) {
            SlashCommand.PING -> TODO()
            SlashCommand.REVALID -> TODO()
            SlashCommand.FILE -> TODO()
            SlashCommand.MACHI -> TODO()
            SlashCommand.STAT_SEASON -> TODO()
            SlashCommand.STAT_MONTH -> TODO()
            SlashCommand.STAT_ENTIRE -> TODO()
            SlashCommand.RANK_SEASON -> TODO()
            SlashCommand.RANK_MONTH -> TODO()
            SlashCommand.RANK_ENTIRE -> TODO()
            SlashCommand.ADMIN_ADD -> TODO()
            SlashCommand.ADMIN_GET -> TODO()
            SlashCommand.ADMIN_DELETE -> TODO()
            SlashCommand.GAME_GROUP_ADD -> TODO()
            SlashCommand.GAME_GROUP_GET -> TODO()
            SlashCommand.ADD -> TODO()
            SlashCommand.DELETE -> TODO()
            SlashCommand.MODIFY -> TODO()

            SlashCommand.NOT_IMPLEMENT -> TODO()
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