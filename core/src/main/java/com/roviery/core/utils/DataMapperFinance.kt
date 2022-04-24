package com.roviery.core.utils

import com.roviery.core.data.source.local.entity.FinanceEntity
import com.roviery.core.domain.model.Finance

object DataMapperFinance {
    fun mapDomainToEntity(input: Finance) =
        FinanceEntity(
            financeType = input.financeType,
            financeFundAllocation = input.financeFundAllocation
        )

    fun mapEntitiesToDomain(input: List<FinanceEntity>): List<Finance> =
        input.map {
            Finance(
                financeType = it.financeType,
                financeFundAllocation = it.financeFundAllocation
            )
        }
}