package com.example.springdatabasicdemo.util.validation.car;

import com.example.springdatabasicdemo.repositories.ModelRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueModelNameValidator implements ConstraintValidator<UniqueModelName, String> {
    private final ModelRepository modelRepository;

    public UniqueModelNameValidator(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return modelRepository.findByName(value).isEmpty();
    }
}
