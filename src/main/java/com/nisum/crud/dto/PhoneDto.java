package com.nisum.crud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.nisum.crud.model.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class PhoneDto {
	
	private String number;
	private String citycode;
	private String contrycode;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
