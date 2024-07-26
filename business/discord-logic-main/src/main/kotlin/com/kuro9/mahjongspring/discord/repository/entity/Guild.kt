package com.kuro9.mahjongspring.discord.repository.entity

data class Guild(
    val id: Long,
    val name: String,
    val iconImgUrl: String,
    val configStr: String,
)
