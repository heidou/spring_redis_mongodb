package com.heidou.repository;

import com.heidou.model.StudentDO;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: heidou
 * @description:
 * @data2017/5/26.
 */
@Repository
public interface StudentRepository extends MongoRepository<StudentDO,String> {
    List<StudentDO> findByName(String name);
}
