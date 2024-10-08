package m.kash.bookmyshowoct24.services;

import m.kash.bookmyshowoct24.models.User;
import m.kash.bookmyshowoct24.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository=userRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }
    public User signUp(String name,
                       String email,
                       String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User savedUser = null;

        if (optionalUser.isPresent()){
            //Move to Login workflow.
        }else {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            savedUser = userRepository.save(user);
        }
        return savedUser;
    }
}

//BCrypt password encoder.
