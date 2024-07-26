package com.kuro9.mahjongspring.discord.repository.entity

import com.kuro9.mahjongspring.discord.Mahjong
import java.time.LocalDateTime

data class GameResult(
    val id: Long,
    val guildId: Long,

    val gameType: Mahjong.Type,
    val channel: String,

    val createdBy: Long,
    val updatedBy: Long,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) {


}
