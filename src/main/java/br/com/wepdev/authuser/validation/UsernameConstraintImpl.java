package br.com.wepdev.authuser.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameConstraintImpl implements ConstraintValidator<UsernameConstraint, String> {

    @Override
    public void initialize(UsernameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    // Implementacao original
//    @Override
//    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
//        if(username == null || username.trim().isEmpty() || username.contains(" ")){
//            return false;
//        }
//        return true;
//    }

    // Implementacao melhorada
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return username != null && !username.trim().isEmpty() && !username.contains(" ");
    }
}
