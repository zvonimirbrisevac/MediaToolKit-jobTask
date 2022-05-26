package com.mkt.ipaddressresolver.models

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class RequestInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_seq")
    @SequenceGenerator(name = "request_seq", sequenceName = "request_seq", allocationSize = 1)
    @JoinColumn(name = "id")
    val id: Long = 0,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val requestTimestamp: LocalDateTime,
    val requestIp: String,
    val searchedIp: String
)
