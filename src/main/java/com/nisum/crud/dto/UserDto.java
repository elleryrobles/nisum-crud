package com.nisum.crud.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.nisum.crud.model.Phone;
import com.nisum.crud.model.User;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class UserDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String email;
	private String password;
	private List<Phone> phones;
	private boolean isActive;
	private OffsetDateTime created;
	private OffsetDateTime modified;
	
	
	public static final Function<UserDto, User> CONVERTER_ENTITY = (UserDto t) -> {
		
		List<Phone> phones = new ArrayList<Phone>();
		phones.addAll(t.getPhones());
		
		User user = new User();
		user.setName(t.getName());
		user.setEmail(t.getEmail());
		user.setPassword(t.getPassword());
		user.setPhones(phones);
		user.setActive(t.isActive);
		
		return user;
	};
	
	public static final Function<User, UserDto> CONVERTER_DTO = (User t) -> {
		UserDto userDto = new UserDto();

		userDto.setId(t.getId());
		userDto.setName(t.getName());
		userDto.setEmail(t.getEmail());
		userDto.setPassword(t.getPassword());
		userDto.setPhones(t.getPhones());
		userDto.setActive(t.isActive());
		userDto.setCreated(t.getCreated());
		userDto.setModified(t.getModified());
		
		
		/*dto.setPeriodoInicio(t.getPeriodoInicio());
		dto.setPeriodoFin(t.getPeriodoFin());
		dto.setObservaciones(t.getObservaciones());

		dto.setFechaCreacion(t.getFechaCreacion());
		dto.setUsuarioCreacion(t.getUsuarioCreacion());
		dto.setUsuarioModificacion(t.getUsuarioModificacion());
		dto.setFechaModificacion(t.getFechaModificacion());*/

		return userDto;
	};
	
	

}
