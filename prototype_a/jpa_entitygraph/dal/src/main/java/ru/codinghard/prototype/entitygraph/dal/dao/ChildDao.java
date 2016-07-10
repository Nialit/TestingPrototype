package ru.codinghard.prototype.entitygraph.dal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.codinghard.prototype.entitygraph.dal.model.Child;
import ru.codinghard.prototype.entitygraph.dal.model.Parent;

import java.util.Collection;
import java.util.Optional;

public interface ChildDao extends JpaRepository<Child, Long> {
    Optional<Child> findById(long id);

    Collection<Child> findByNameContainingIgnoreCase(String name);

    Collection<Child> findByParent(Parent parent);
}
