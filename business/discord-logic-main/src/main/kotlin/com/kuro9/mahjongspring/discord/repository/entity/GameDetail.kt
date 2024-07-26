package com.kuro9.mahjongspring.discord.repository.entity

import com.kuro9.enums.DbStatus
import java.time.LocalDateTime

data class GameDetail(
    val resultId: Long,
    val userId: Long,

    val rank: Int,
    val score: Int,

    val createdBy: Long,
    val updatedBy: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,

    val dbStatus: DbStatus,
)
