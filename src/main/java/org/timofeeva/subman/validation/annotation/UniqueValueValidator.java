package org.timofeeva.subman.validation.annotation;

import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private final EntityManager entityManager;

    private Class<?> referenceClass;

    private String referenceField;

    @Override
    public void initialize(UniqueValue uniqueValueAnnotation) {
        ConstraintValidator.super.initialize(uniqueValueAnnotation);
        this.referenceClass = uniqueValueAnnotation.referenceClass();
        this.referenceField = uniqueValueAnnotation.referenceField();
    }

    @Override
    @SuppressWarnings("unsafe")
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String jpql = "SELECT count(e) FROM " + referenceClass.getSimpleName() +
                " e WHERE e." + referenceField + " = :value";

        return entityManager.createQuery(jpql, Long.class).setParameter("value", o).getSingleResult() == 0;
    }

}
