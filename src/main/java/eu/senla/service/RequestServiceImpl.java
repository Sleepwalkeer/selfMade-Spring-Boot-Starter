package eu.senla.service;

import eu.senla.entity.Request;
import eu.senla.repository.RequestRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService{

    private final RequestRepository requestRepository;

    @Override
    @SneakyThrows
    public void handleRequest(HttpServletRequest httpRequest) {
        Request request = Request.builder()
                .url(httpRequest.getRequestURL().toString())
                .method(httpRequest.getMethod())
                .headers(extractHeaders(httpRequest))
                .build();
        requestRepository.save(request);
    }

    private Map<String, String> extractHeaders(HttpServletRequest httpRequest) {
        return Collections.list(httpRequest.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(h -> h, httpRequest::getHeader));
    }
}
