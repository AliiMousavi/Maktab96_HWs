package erpSystem.repository;

import erpSystem.base.repository.BaseRepository;
import erpSystem.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface UserRepository<T extends User>  extends BaseRepository<T , Long> {
    boolean isUserExistsByUsername(String username);

    boolean  isUserExistsByEmail(String email);

    T getUserByUsername(String username);
    Optional<T> getUserByEmail(String email);
    public String getLogInRoleByUsername(String username);
}
