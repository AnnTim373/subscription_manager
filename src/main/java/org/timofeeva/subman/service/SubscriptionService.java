package org.timofeeva.subman.service;

import org.timofeeva.subman.dto.input.SubscriptionInput;
import org.timofeeva.subman.dto.output.SubscriptionOutput;

import java.util.List;

public interface SubscriptionService {

    SubscriptionOutput createSubscription(SubscriptionInput subscriptionInput);

    SubscriptionOutput updateSubscription(Long id, SubscriptionInput subscriptionInput);

    SubscriptionOutput getSubscription(Long id);

    void deleteSubscription(Long id);

    List<SubscriptionOutput> getTopSubscriptions();

}
