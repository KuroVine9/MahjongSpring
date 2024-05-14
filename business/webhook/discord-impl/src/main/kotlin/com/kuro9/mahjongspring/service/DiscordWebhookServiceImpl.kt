package com.kuro9.mahjongspring.service

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service

@Service
class DiscordWebhookServiceImpl : WebhookService {
    override fun sendErrorMessage(e: Throwable, request: HttpServletRequest) {
        TODO("Not yet implemented")
    }

    override fun sendDebugMessage(message: String?, request: HttpServletRequest) {
        TODO("Not yet implemented")
    }

    override fun sendDebugMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun sendCustomMessage(message: String) {
        TODO("Not yet implemented")
    }

}