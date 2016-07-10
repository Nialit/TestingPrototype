package ru.codinghard.prototype.entitygraph.dal.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;

@Getter
@Setter
@NoArgsConstructor
@ToString(of = {
        "id",
        "name"
})
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "child")
public class Child {
    @Id
    @SequenceGenerator(name = "child_id_seq", sequenceName = "child_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "child_id_seq")
    private Long id;

    @NonNull
    @Column(length = 200)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Parent parent;


}
