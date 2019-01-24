package com.noip.topic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Anton on 13.08.2018.
 */
@Repository
public interface TopicRepository extends CrudRepository<User,Integer> {
    Optional<User> findById(int id);
    List<User> findAll();
    void deleteById(int id);
    <S extends User> S save(S s);

}
