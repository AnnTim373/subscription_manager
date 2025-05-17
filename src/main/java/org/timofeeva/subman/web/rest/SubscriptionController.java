package org.timofeeva.subman.web.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.timofeeva.subman.dto.input.SubscriptionInput;
import org.timofeeva.subman.dto.output.SubscriptionOutput;
import org.timofeeva.subman.service.SubscriptionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<SubscriptionOutput> subscribe(@Valid @RequestBody SubscriptionInput subscription) {
        return ResponseEntity.ok(subscriptionService.createSubscription(subscription));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionOutput> updateUser(@PathVariable Long id,
                                                         @Valid @RequestBody SubscriptionInput subscription) {
        return ResponseEntity.ok(subscriptionService.updateSubscription(id, subscription));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionOutput> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(subscriptionService.getSubscription(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/top")
    public ResponseEntity<List<SubscriptionOutput>> getTopSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getTopSubscriptions());
    }

}
