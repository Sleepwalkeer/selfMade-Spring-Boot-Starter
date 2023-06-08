package eu.senla.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface RequestService {

    void handleRequest(HttpServletRequest request);
}
