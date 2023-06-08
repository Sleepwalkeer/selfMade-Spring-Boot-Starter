package eu.senla.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Requests")
public class Request {

    @Id
    private String id;
    private String url;
    private String method;
    private String body;
    private Map<String,String> headers;
}
