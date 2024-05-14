package com.kuro9.mahjongspring.service

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service

@Service
interface WebhookService {
    fun sendErrorMessage(e: Throwable, request: HttpServletRequest)
    fun sendDebugMessage(message: String? = null, request: HttpServletRequest)
    fun sendDebugMessage(message: String)
    fun sendCustomMessage(message: String)
}