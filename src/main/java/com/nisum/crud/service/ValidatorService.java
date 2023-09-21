package com.nisum.crud.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.nisum.crud.exception.MessageErrorException;
import com.nisum.crud.model.User;

@Service
public class ValidatorService {
	
	private String EMAIL_REGEX = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
    private Pattern pattern = Pattern.compile(EMAIL_REGEX);

	public void validateUser(User user) {
		
        if (!isValidEmail(user.getEmail())) {
            throw new MessageErrorException("Formato de correo inválido, ejemplo: 'aaaaaaa@dominio.cl'");
        }
    }

    private boolean isValidEmail(String email) {
    	Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
