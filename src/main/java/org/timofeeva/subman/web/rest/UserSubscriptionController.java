package org.timofeeva.subman.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.timofeeva.subman.dto.output.SubscriptionOutput;
import org.timofeeva.subman.service.UserSubscriptionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/{user_id}/subscriptions")
public class UserSubscriptionController {

    private final UserSubscriptionService userSubscriptionService;

    @PostMapping("/{subscription_id}")
    public ResponseEntity<Void> subscribe(@PathVariable(value = "user_id") Long userId,
                                          @PathVariable(value = "subscription_id") Long subscriptionId) {
        userSubscriptionService.subscribe(userId, subscriptionId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionOutput>> getSubscription(@PathVariable(value = "user_id") Long userId) {
        return ResponseEntity.ok(userSubscriptionService.getUserSubscriptions(userId));
    }

    @DeleteMapping("/{subscription_id}")
    public ResponseEntity<Void> unsubscribe(@PathVariable(value = "user_id") Long userId,
                                            @PathVariable(value = "subscription_id") Long subscriptionId) {
        userSubscriptionService.unsubscribe(userId, subscriptionId);
        return ResponseEntity.ok().build();
    }

}
