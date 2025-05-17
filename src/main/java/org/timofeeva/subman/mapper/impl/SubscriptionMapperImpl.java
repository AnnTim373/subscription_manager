package org.timofeeva.subman.mapper.impl;

import org.springframework.stereotype.Component;
import org.timofeeva.subman.domain.Subscription;
import org.timofeeva.subman.dto.input.SubscriptionInput;
import org.timofeeva.subman.dto.output.SubscriptionOutput;
import org.timofeeva.subman.mapper.SubscriptionMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
class SubscriptionMapperImpl implements SubscriptionMapper {

    @Override
    public List<SubscriptionOutput> toOutputDTO(List<Subscription> subscriptionList) {
        return subscriptionList.stream().map(this::toOutputDTO).collect(Collectors.toList());
    }

    @Override
    public SubscriptionOutput toOutputDTO(Subscription subscription) {
        return SubscriptionOutput.builder()
                .id(subscription.getId())
                .name(subscription.getName())
                .description(subscription.getDescription())
                .build();
    }

    @Override
    public Subscription fromInputDTO(SubscriptionInput subscriptionInput) {
        return Subscription.builder()
                .name(subscriptionInput.getName())
                .description(subscriptionInput.getDescription())
                .build();
    }

}
