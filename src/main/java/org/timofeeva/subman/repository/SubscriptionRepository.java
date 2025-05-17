package org.timofeeva.subman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.timofeeva.subman.domain.Subscription;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query(nativeQuery = true, value =
            "select * " +
                    "from sub_man.subscriptions " +
                    "where id in (select subscription_id " +
                    "             from sub_man.users_subscriptions " +
                    "             group by subscription_id " +
                    "             order by count(subscription_id) desc " +
                    "             limit :limit)")
    List<Subscription> findAllTop(Integer limit);

}
