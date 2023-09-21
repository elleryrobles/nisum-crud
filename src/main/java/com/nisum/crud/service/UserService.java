package com.nisum.crud.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.crud.exception.MessageErrorException;
import com.nisum.crud.model.Phone;
import com.nisum.crud.model.User;
import com.nisum.crud.repository.PhoneRepository;
import com.nisum.crud.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	
	
	
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private PhoneRepository phoneRepository;
	
	@Autowired
    private ValidatorService validatorService;
	
	/*private final ValidatorService validatorService;
	
	@Autowired
    public UserService(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }*/

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
    	
    	// Servicio implementado para validaciones
    	//validatorService.validateUser(user);
    	
    	// Se lanza excepcion si se identifica que el correo ya existe en la base de datos
    	if (userRepository.findByEmail(user.getEmail()) != null) {
    		throw new MessageErrorException("El correo ya registrado");
        }
    	
    	// Se le asigna el usuario a los telefonos 
    	List<Phone> phones = user.getPhones();
        if (phones != null) {
            for (Phone phone : phones) {
                phone.setUser(user);
            }
        }
    	
        // Se almacena el objeto user
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
    	
    	// Obtenemos el usuario a actualizar
    	User userStorage = userRepository.findById(id).orElse(null);
    	
    	// Realizamos unas validaciones
    	if (userStorage == null) {
    		throw new MessageErrorException("El usuario no encontrado");
    	}
    	
    	if (!userStorage.getEmail().equals(user.getEmail())) {
    		throw new MessageErrorException("El correo no se puede modificar");
    	}
    	
    	// Eliminamos los telefonbos asociados al usuario
    	List<Phone> phoneUser = phoneRepository.findByUser(userStorage);
    	if(phoneUser.size() > 0) {
	        for (Phone phone : phoneUser) {
	        	phoneRepository.deleteById(phone.getId());
	        }
    	}
    	
    	// Seteamos la data de telefonos a nuevo objeto y se persiste a la base de datos
    	List<Phone> phones = user.getPhones();
        if (phones != null) {
            for (Phone phone : phones) {
            	Phone phoneNew = new Phone();
            	phoneNew.setNumber(phone.getNumber());
            	phoneNew.setCitycode(phone.getCitycode());
            	phoneNew.setContrycode(phone.getContrycode());
            	phoneNew.setUser(userStorage);
            	phoneRepository.save(phoneNew);
            }
        }
    	
    	// Seteamos la data que se va a modificar 
    	// y como paso final, almacenar el objeto userStorage con los datos modificados
    	userStorage.setName(user.getName());
    	userStorage.setPassword(user.getPassword());
    	userStorage.setModified(OffsetDateTime.now());
    	
        return userRepository.save(userStorage);
    }
    
    
    public void deleteUser(Long id) {
    	
    	User user = userRepository.findById(id).orElse(null);
    	List<Phone> phoneUser = phoneRepository.findByUser(user);
    	
    	if(phoneUser.size() > 0) {
	        for (Phone phone : phoneUser) {
	        	phoneRepository.deleteById(phone.getId());
	        }
    	}
    	
        userRepository.deleteById(id);
    }
    
    
    public User disableUser(Long id) {
    	
    	User user = userRepository.findById(id).orElse(null);
    	if (user == null) {
    		throw new MessageErrorException("El usuario no encontrado");
    	}
    	
    	user.setActive(false);
        return userRepository.save(user);
    }
    
public User enableUser(Long id) {
    	
    	User user = userRepository.findById(id).orElse(null);
    	if (user == null) {
    		throw new MessageErrorException("El usuario no encontrado");
    	}
    	
    	user.setActive(true);
        return userRepository.save(user);
    }
}
