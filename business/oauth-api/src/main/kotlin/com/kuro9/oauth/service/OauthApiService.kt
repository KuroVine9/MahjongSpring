package com.kuro9.oauth.service

import com.kuro9.oauth.model.OauthRequest
import com.kuro9.oauth.model.OauthResponse
import org.springframework.stereotype.Service

@Service
class OauthApiService {
    fun getOauthResponse(request: OauthRequest): OauthResponse = when (request) {
        is OauthRequest.Discord -> {
            TODO()
        }
    }
}