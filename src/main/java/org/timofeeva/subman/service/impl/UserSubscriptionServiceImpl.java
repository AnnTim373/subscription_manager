package org.timofeeva.subman.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.timofeeva.subman.domain.Subscription;
import org.timofeeva.subman.domain.User;
import org.timofeeva.subman.dto.output.SubscriptionOutput;
import org.timofeeva.subman.error.custom_exception.SubscriptionNotFoundException;
import org.timofeeva.subman.error.custom_exception.UserNotFoundException;
import org.timofeeva.subman.mapper.SubscriptionMapper;
import org.timofeeva.subman.repository.SubscriptionRepository;
import org.timofeeva.subman.repository.UserRepository;
import org.timofeeva.subman.service.UserSubscriptionService;

import java.util.List;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
class UserSubscriptionServiceImpl implements UserSubscriptionService {

    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    private final SubscriptionMapper subscriptionMapper;

    @Override
    public void subscribe(Long userId, Long subscriptionId) {
        log.info("Subscribing user {} to subscription {}", userId, subscriptionId);
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Subscription subscription = subscriptionRepository
                .findById(subscriptionId).orElseThrow(SubscriptionNotFoundException::new);
        user.getSubscriptions().add(subscription);
        userRepository.save(user);
    }

    @Override
    public void unsubscribe(Long userId, Long subscriptionId) {
        log.info("Unsubscribing user {} to subscription {}", userId, subscriptionId);
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Subscription subscription = subscriptionRepository
                .findById(subscriptionId).orElseThrow(SubscriptionNotFoundException::new);
        user.getSubscriptions().remove(subscription);
        userRepository.save(user);
    }

    @Override
    public List<SubscriptionOutput> getUserSubscriptions(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return subscriptionMapper.toOutputDTO(user.getSubscriptions());
    }

}
