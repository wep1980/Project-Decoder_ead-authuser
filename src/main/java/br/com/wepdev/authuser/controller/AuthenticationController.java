package br.com.wepdev.authuser.controller;

import br.com.wepdev.authuser.dto.UserDTO;
import br.com.wepdev.authuser.enums.UserStatus;
import br.com.wepdev.authuser.enums.UserType;
import br.com.wepdev.authuser.model.UserModel;
import br.com.wepdev.authuser.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", maxAge = 3600)// Permite que todos os endpoints desse controller sejam acessados de qq lugar
public class AuthenticationController {

    // Adicionando logger na classe
    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@RequestBody @Validated(UserDTO.UserView.RegistrationPost.class)
                                                   @JsonView(UserDTO.UserView.RegistrationPost.class) UserDTO userDTO){

        if(userService.existsByUsername(userDTO.getUsername())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Username is Already Taken!");
        }
        if(userService.existsByEmail(userDTO.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: email is Already Taken!");
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);
        userModel.setUserStatus(UserStatus.ACTIVE);
        userModel.setUserType(UserType.STUDENT);
        userModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        userModel.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        userService.save(userModel);

       return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }


    @GetMapping("/")
    public String index(){

        // Trabalhando com os niveis de LOG

        logger.trace("TRACE"); // Para vizualizar mais de forma granular(detalhado)
        logger.debug("DEBUG"); // Utilizado em modo de DEV para trazer infos mais detalhadas como metedos
        logger.info("INFO"); // Utilizado mais em PROD, para trazer informacoes do que esta acontecendo
        logger.warn("WARN");  // Logo que mostra um detalhado alerta
        logger.error("ERROR"); // E quando algo da errado no sistema e ter um controle do que esta acontecendo, usando dentro de um Try Catch
        return "Logging Spring Boot...";
    }
}
