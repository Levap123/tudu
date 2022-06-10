package com.example.tudu.sevice;

import com.example.tudu.entity.UserEntity;
import com.example.tudu.exceptions.UserAlreadyExistException;
import com.example.tudu.exceptions.UserNotFoundException;
import com.example.tudu.model.User;
import com.example.tudu.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {

        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User with this username already exist");
        }

        return userRepo.save(user);
    }


    public User getOneUser(Long id) throws UserNotFoundException {
        UserEntity user;
        if (userRepo.existsById(id)) {
            user = userRepo.findById(id).get();
        } else {
            throw new UserNotFoundException("user not found");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
