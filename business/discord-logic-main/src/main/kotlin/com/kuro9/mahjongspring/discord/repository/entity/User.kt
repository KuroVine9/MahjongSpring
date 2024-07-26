package com.kuro9.mahjongspring.discord.repository.entity

data class User(
    val id: Long,
    val username: String,
    val avatarUrl: String,
)