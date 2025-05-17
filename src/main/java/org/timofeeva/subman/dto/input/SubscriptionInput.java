package org.timofeeva.subman.dto.input;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.timofeeva.subman.domain.Subscription;
import org.timofeeva.subman.validation.annotation.UniqueValue;

@Data
public class SubscriptionInput {

    @NotEmpty(message = "Поле name обязательно для заполнения")
    @UniqueValue(
            message = "Подписка с таким названием уже существует",
            referenceClass = Subscription.class,
            referenceField = "name"
    )
    private String name;

    private String description;

}
