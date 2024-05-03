package com.nogueira.springexpert.util.validation.constraintvalidation;

import com.nogueira.springexpert.util.validation.NotEmptyList;
import com.nogueira.springexpert.util.validation.NotEmptyList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Objects;

public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List> {

   public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
      return Objects.nonNull(list) && !list.isEmpty();
   }

}
