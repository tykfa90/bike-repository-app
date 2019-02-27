package pl.sda.bikerepositoryapp.service;

import pl.sda.bikerepositoryapp.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
