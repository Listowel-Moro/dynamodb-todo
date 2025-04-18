package com.listo.DynamoDBToDo.repository;

import com.listo.DynamoDBToDo.model.Todo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
public interface TodoRepository extends CrudRepository<Todo, String> {
}