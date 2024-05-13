package com.kuro9.oauth.model

sealed interface OauthResponse {
    val userId: Long
    val userName: String
    val accessToken: String

}
