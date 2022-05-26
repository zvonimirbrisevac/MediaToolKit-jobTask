package com.mkt.ipaddressresolver.dto

//{"ip":"8.8.8.8","ip_number":"134744072","ip_version":4,"country_name":"United States of America","country_code2":"US",
//    "isp":"Google LLC","response_code":"200","response_message":"OK"}
class WebIpInfoDTO(
    val ip: String,
    val ip_number: String,
    val ip_version: Int,
    val country_name: String,
    val country_code2: String,
    val isp: String,
    val response_code: String,
    val response_message: String
) {
    constructor() : this("", "", 0,"","", "",
    "", "") {}
}
