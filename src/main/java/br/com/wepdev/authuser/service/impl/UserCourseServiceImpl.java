package br.com.wepdev.authuser.service.impl;

import br.com.wepdev.authuser.repository.UserCourseRepository;
import br.com.wepdev.authuser.service.UserCourseService;
import org.springframework.stereotype.Service;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    final
    UserCourseRepository userCourseRepository;

    public UserCourseServiceImpl(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

}
