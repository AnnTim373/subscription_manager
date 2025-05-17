package org.timofeeva.subman.mapper;

import org.timofeeva.subman.domain.Subscription;
import org.timofeeva.subman.dto.input.SubscriptionInput;
import org.timofeeva.subman.dto.output.SubscriptionOutput;

import java.util.List;

public interface SubscriptionMapper {

    List<SubscriptionOutput> toOutputDTO(List<Subscription> subscriptionList);

    SubscriptionOutput toOutputDTO(Subscription subscription);

    Subscription fromInputDTO(SubscriptionInput subscriptionInput);

}
