package com.littlesekii.incentivo.modules.user.service;

import com.littlesekii.incentivo.modules.user.entity.User;
import com.littlesekii.incentivo.modules.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).get();
    }

    public User save(User user) { return repository.save(user); }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User user) {
        User userReference = repository.getReferenceById(id);
        updateData(userReference, user);
        return save(userReference);
    }

    private void updateData(User userReference, User user) {
        userReference.setName(user.getName());
        userReference.setEmail(user.getEmail());
        userReference.setPhone(user.getPhone());
    }

}
