package br.com.wepdev.authuser.repository;

import br.com.wepdev.authuser.model.UserCourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserCourseRepository extends JpaRepository<UserCourseModel, UUID> {

}
