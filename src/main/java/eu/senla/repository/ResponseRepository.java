package eu.senla.repository;

import eu.senla.entity.Response;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponseRepository  extends MongoRepository<Response,String> {
}
