package com.kuro9.mahjongspring.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan


@ConfigurationProperties("app.discord.webhook.channel")
@ConfigurationPropertiesScan
data class WebhookProfile(
    val error: String,
    val debug: String,
    val normal: String
)