package ru.codinghard.prototype.entitygraph.dal.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@ToString(of = {
        "id",
        "name",
        "child"
})
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "parent")
@NamedEntityGraph(name = "Parent.children",
        attributeNodes = @NamedAttributeNode("children"))
public class Parent {
    @Id
    @SequenceGenerator(name = "parent_id_seq", sequenceName = "parent_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "parent_id_seq")
    private Long id;

    @NonNull
    @Column(length = 200)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="parent")
    private Collection<Child> children;

    public Parent(String name){
        this.name = name;
    }

}
