package com.kuro9.oauth.model

sealed interface OauthRequest {

    data class Discord(
        val clientId: String,
        val clientSecret: String,
        val grantType: String,
        val code: String,
        val redirectUri: String,
        val scope: String
    ) : OauthRequest
}