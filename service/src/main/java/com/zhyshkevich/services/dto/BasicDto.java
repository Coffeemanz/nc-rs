package com.zhyshkevich.services.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Сергей on 31.05.2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BasicDto {

    public int id;
    public String httpStatus;

    public  BasicDto(){}

    public BasicDto(int id, String httpStatus)
    {
        this.id = id;
        this.httpStatus = httpStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }
}
