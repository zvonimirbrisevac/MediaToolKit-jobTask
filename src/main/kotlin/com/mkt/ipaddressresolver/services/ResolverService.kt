package com.mkt.ipaddressresolver.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.mkt.ipaddressresolver.dto.ResponseLocationInfoDTO
import com.mkt.ipaddressresolver.dto.WebIpInfoDTO
import com.mkt.ipaddressresolver.exceptions.IpInWrongFormatException
import com.mkt.ipaddressresolver.exceptions.IpNotResolvedException
import com.mkt.ipaddressresolver.models.RequestInfo
import com.mkt.ipaddressresolver.repos.RequestInfoRepo
import org.springframework.http.MediaType
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.stereotype.Service
import org.springframework.util.MimeTypeUtils.TEXT_HTML
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import java.time.LocalDateTime


@Service
class ResolverService(
    private val webClient: WebClient,
    private val requestInfoRepo: RequestInfoRepo
) {

    fun resolveAndStoreIp(ip: String, remoteAddr: String, time: LocalDateTime): ResponseLocationInfoDTO? {
        val webIpInfoDTO: WebIpInfoDTO? = fetchIpInfo(ip)
        if (webIpInfoDTO?.response_code == "400" || webIpInfoDTO?.response_code == "404") {
            throw IpNotResolvedException("Request failed!")
        }
        if (webIpInfoDTO?.ip_version == 6) {
            throw IpInWrongFormatException("Ip is in IPv6 format!")
        }
        val locationCode2: String? = webIpInfoDTO?.country_code2

        requestInfoRepo.saveAndFlush(RequestInfo(0, time, remoteAddr, ip))
        return locationCode2?.let { ResponseLocationInfoDTO(it) }
    }

    private fun fetchIpInfo(ip: String): WebIpInfoDTO? {
        return webClient.get()
            .uri { builder -> builder.path("/")
                .queryParam("ip", ip)
                .queryParam("format", "json")
                .build() }
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono<WebIpInfoDTO>()
            .block()
    }


}
