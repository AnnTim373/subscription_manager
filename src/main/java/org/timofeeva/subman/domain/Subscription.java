package org.timofeeva.subman.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(schema = "sub_man", name = "subscriptions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subscription {

    @Id
    @Column(name = "id")
    @SequenceGenerator(
            schema = "sub_man",
            name = "seq_subscriptions",
            sequenceName = "seq_subscriptions",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_subscriptions")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
