package eu.senla.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
@RequiredArgsConstructor
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    private final StarterSelfMadeProperties properties;

    @Override
    protected String getDatabaseName() {
        var connectionString = new ConnectionString("mongodb://localhost:27017/request");
        return connectionString.getDatabase();
    }

    @Override
    public MongoClient mongoClient() {
        var connectionString = new ConnectionString("mongodb://localhost:27017/request");
        var settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(settings);
    }
}
