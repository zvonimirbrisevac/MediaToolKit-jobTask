package com.mkt.ipaddressresolver.repos

import com.mkt.ipaddressresolver.models.RequestInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.Repository


interface RequestInfoRepo: JpaRepository<RequestInfo, Long> {

}
