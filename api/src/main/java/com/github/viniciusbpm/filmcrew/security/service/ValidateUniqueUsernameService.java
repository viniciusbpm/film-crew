<<<<<<< Updated upstream
package com.github.viniciusbpm.filmcrew.security.service;

import com.github.viniciusbpm.filmcrew.domain.UserModel;
import com.github.viniciusbpm.filmcrew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ValidateUniqueUsernameService {
    public static final String USERNAME_TAKEN_MESSAGE = "This username is already being used";
    @Autowired
    private UserRepository userRepository;

    public void validate(String username){
        Optional<UserModel> user = userRepository.findByUsername(username);

        if(user.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, USERNAME_TAKEN_MESSAGE);
        }
    }
=======
package com.github.viniciusbpm.filmcrew.security.service;public class ValidateUniqueUsernameService {
>>>>>>> Stashed changes
}
