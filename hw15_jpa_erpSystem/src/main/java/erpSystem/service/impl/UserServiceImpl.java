package erpSystem.service.impl;

import erpSystem.base.repository.BaseRepository;
import erpSystem.base.service.BaseService;
import erpSystem.base.service.impl.BaseServiceImpl;
import erpSystem.entity.User;
import erpSystem.repository.UserRepository;
import erpSystem.service.UserService;


import java.io.Serializable;
import java.util.Optional;
import java.util.regex.Pattern;

public class UserServiceImpl<T extends User>
        extends BaseServiceImpl<T,Long,UserRepository<T>>
        implements UserService<T> {
    public UserServiceImpl(UserRepository<T> repository) {
        super(repository);
    }

    @Override
    public boolean isUserExistsByUsername(String username) {
        return repository.isUserExistsByUsername(username);
    }

    @Override
    public boolean isUserExistsByEmail(String email) {
        return repository.isUserExistsByEmail(email);
    }

    @Override
    public boolean isValidCredential(String... credential) {
        Optional<T> foundUser;
        if (isValidEmailPattern(credential[1])){
            foundUser=repository.getUserByEmail(credential[1]);
            if (foundUser.isPresent()) {
                return credential[1].equals(foundUser.get().getEmail())
                        && credential[2].equals(foundUser.get().getPassword());
            }

        }else {
            foundUser= Optional.ofNullable(repository.getUserByUsername(credential[0]));
            if (foundUser.isPresent()) {
                return credential[0].equals(foundUser.get().getUsername())
                        && credential[2].equals(foundUser.get().getPassword());
            }
        }
        return false;
    }

    @Override
    public boolean isValidEmailPattern(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(emailRegex,email);
    }

    @Override
    public String getLogInRoleByUsername(String username) {
        return repository.getLogInRoleByUsername(username);
    }

    @Override
    public T getUserByUsername(String username) {
        return repository.getUserByUsername(username);
    }
}
