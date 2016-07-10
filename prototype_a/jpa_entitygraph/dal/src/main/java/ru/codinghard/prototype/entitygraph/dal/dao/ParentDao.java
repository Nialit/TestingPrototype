package ru.codinghard.prototype.entitygraph.dal.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.codinghard.prototype.entitygraph.dal.model.Parent;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ParentDao extends JpaRepository<Parent, Long> {
    Optional<Parent> findById(long id);

    @EntityGraph(value = "Parent.children", type = EntityGraph.EntityGraphType.LOAD)
    @Query(value = "select distinct parent from Parent parent")
    List<Parent> findAllWithChildren();

    Collection<Parent> findByNameContainingIgnoreCase(String name);
}
