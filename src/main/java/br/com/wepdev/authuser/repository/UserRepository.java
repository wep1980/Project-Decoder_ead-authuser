package br.com.wepdev.authuser.repository;

import br.com.wepdev.authuser.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> , JpaSpecificationExecutor<UserModel> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
