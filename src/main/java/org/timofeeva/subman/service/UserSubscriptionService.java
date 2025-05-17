package org.timofeeva.subman.service;

import org.timofeeva.subman.dto.output.SubscriptionOutput;

import java.util.List;

public interface UserSubscriptionService {

    void subscribe(Long userId, Long subscriptionId);

    void unsubscribe(Long userId, Long subscriptionId);

    List<SubscriptionOutput> getUserSubscriptions(Long userId);

}
