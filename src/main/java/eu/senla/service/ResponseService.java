package eu.senla.service;

import eu.senla.entity.Response;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.util.ContentCachingResponseWrapper;

public interface ResponseService {

    void handleResponse(Response response);
}
