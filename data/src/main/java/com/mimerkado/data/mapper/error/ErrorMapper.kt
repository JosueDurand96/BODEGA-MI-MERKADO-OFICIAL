package com.mimerkado.data.mapper.error

import com.mimerkado.data.entities.exception.ErrorEntity
import com.mimerkado.data.mapper.Mapper
import com.mimerkado.domain.model.exception.ErrorModel

class ErrorMapper: Mapper<ErrorModel, ErrorEntity>() {

    override fun mapToEntity(type: ErrorEntity): ErrorModel {
        return ErrorModel(
            type.error
        )


    }
}