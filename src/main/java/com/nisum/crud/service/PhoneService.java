package com.nisum.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.crud.model.Phone;
import com.nisum.crud.repository.PhoneRepository;

@Service
public class PhoneService {

	@Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    public Phone getPhoneById(Long id) {
        return phoneRepository.findById(id).orElse(null);
    }

    public Phone createPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public Phone updatePhone(Long id, Phone phone) {
        if (phoneRepository.existsById(id)) {
            phone.setId(id);
            return phoneRepository.save(phone);
        }
        return null;
    }

    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }
}
