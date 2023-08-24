package erpSystem.service;

import erpSystem.base.service.BaseService;
import erpSystem.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface UserService<T extends User> extends BaseService<T,Long> {
    boolean  isUserExistsByUsername(String username);

    boolean  isUserExistsByEmail(String email);
    boolean  isValidCredential (String... credential);

    boolean isValidEmailPattern(String email);
    String getLogInRoleByUsername(String username);

    T getUserByUsername(String username);
}
