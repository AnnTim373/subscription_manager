package org.timofeeva.subman.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(schema = "sub_man", name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @Column(name = "id")
    @SequenceGenerator(
            schema = "sub_man",
            name = "seq_users",
            sequenceName = "seq_users",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(
            schema = "sub_man",
            name = "users_subscriptions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id")
    )
    private List<Subscription> subscriptions;

}
