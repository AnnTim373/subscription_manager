package org.timofeeva.subman.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.timofeeva.subman.domain.Subscription;
import org.timofeeva.subman.dto.input.SubscriptionInput;
import org.timofeeva.subman.dto.output.SubscriptionOutput;
import org.timofeeva.subman.error.custom_exception.SubscriptionNotFoundException;
import org.timofeeva.subman.mapper.SubscriptionMapper;
import org.timofeeva.subman.repository.SubscriptionRepository;
import org.timofeeva.subman.service.SubscriptionService;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Value("${application.subscription.top.value:3}")
    private Integer topValue;


    @Override
    public SubscriptionOutput createSubscription(SubscriptionInput subscriptionInput) {
        log.info("Creating subscription {}", subscriptionInput);
        return subscriptionMapper.toOutputDTO(
                subscriptionRepository.save(subscriptionMapper.fromInputDTO(subscriptionInput))
        );
    }

    @Override
    public SubscriptionOutput updateSubscription(Long id, SubscriptionInput subscriptionInput) {
        log.info("Updating subscription {}: {}", id, subscriptionInput);
        Subscription subscription = subscriptionMapper.fromInputDTO(subscriptionInput);
        subscription.setId(id);
        return subscriptionMapper.toOutputDTO(subscriptionRepository.save(subscription));
    }

    @Override
    public SubscriptionOutput getSubscription(Long id) {
        return subscriptionMapper.toOutputDTO(
                subscriptionRepository.findById(id).orElseThrow(SubscriptionNotFoundException::new)
        );
    }

    @Override
    public void deleteSubscription(Long id) {
        log.info("Deleting subscription {}", id);
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(SubscriptionNotFoundException::new);
        subscriptionRepository.delete(subscription);
    }

    @Override
    public List<SubscriptionOutput> getTopSubscriptions() {
        return subscriptionMapper.toOutputDTO(subscriptionRepository.findAllTop(topValue));
    }

}
