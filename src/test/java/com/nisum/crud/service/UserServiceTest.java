package com.nisum.crud.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nisum.crud.model.Phone;
import com.nisum.crud.model.User;
import com.nisum.crud.repository.PhoneRepository;
import com.nisum.crud.repository.UserRepository;
import com.nisum.crud.validator.Validator;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PhoneRepository phoneRepository;

    @InjectMocks
    private UserService userService;
    
    @InjectMocks
    private Validator validatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
    	
    	Phone phone1 = new Phone();
    	phone1.setNumber("12345678");
    	phone1.setCitycode("1");
    	phone1.setContrycode("01");
    	
    	Phone phone2 = new Phone();
    	phone2.setNumber("8521463");
    	phone2.setCitycode("5");
    	phone2.setContrycode("57");
    	
    	List<Phone> phones = new ArrayList<>();
    	phones.add(phone1);
    	phones.add(phone2);
    	
        User user = new User();
        user.setId(1L);
        user.setName("Juan Perez");
        user.setEmail("test@example.cl");
        user.setPassword("claveusuario");
        user.setPhones(phones);

        when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertNotNull(createdUser);
        assertEquals(user.getEmail(), createdUser.getEmail());

        verify(userRepository, times(1)).findByEmail(user.getEmail());
        verify(userRepository, times(1)).save(user);
    }
}
