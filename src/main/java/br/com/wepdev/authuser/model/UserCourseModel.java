package br.com.wepdev.authuser.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL) // Oculta os atributos com valores nulos na serialização
@Data
@Entity
@Table(name = "TB_USERS_COURSES")
public class UserCourseModel implements Serializable {
    private static final long serialVersionUID = 721140903527554840L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Um usuario pode estar cadastrado em varios cursos
    private UserModel user;

    @Column(nullable = false)
    private UUID courseId; // Esse valor vai vim do microservice de Course
}
