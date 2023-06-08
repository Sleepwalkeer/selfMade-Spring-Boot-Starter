package eu.senla.repository;

import eu.senla.entity.Request;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestRepository extends MongoRepository<Request,String> {
}
