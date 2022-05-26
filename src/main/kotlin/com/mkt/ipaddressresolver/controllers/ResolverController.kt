package com.mkt.ipaddressresolver.controllers

import com.mkt.ipaddressresolver.dto.IpRequestDTO
import com.mkt.ipaddressresolver.dto.ResponseLocationInfoDTO
import com.mkt.ipaddressresolver.services.ResolverService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

@Controller
class ResolverController(
    private val resolverService: ResolverService
) {

    companion object {
        val log: Logger = LoggerFactory.getLogger(ResolverController::class.java)
    }

    @PostMapping("/location/search")
    fun getIpLocation(@RequestBody ipRequestDTO: IpRequestDTO, request: HttpServletRequest):
            ResponseEntity<ResponseLocationInfoDTO> {
        log.info("Resolving location for ip: ${ipRequestDTO.ip}...")
        log.info("Request ip: ${request.remoteAddr}")
        return ResponseEntity(resolverService.resolveAndStoreIp(ipRequestDTO.ip, request.remoteAddr,
            LocalDateTime.now()), HttpStatus.CREATED);
    }
}
