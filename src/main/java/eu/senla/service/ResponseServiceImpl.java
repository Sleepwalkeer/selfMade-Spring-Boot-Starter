package eu.senla.service;

import eu.senla.entity.Request;
import eu.senla.entity.Response;
import eu.senla.repository.ResponseRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService {

    private final ResponseRepository responseRepository;


    @SneakyThrows
    @Override
    public void handleResponse(HttpServletResponse httpServletResponse) {
        System.out.println("testResp");
        var wrappedResponse = new ContentCachingResponseWrapper(httpServletResponse);
        byte[] responseBodyArr = wrappedResponse.getContentAsByteArray();
        String responseBody;
        if (responseBodyArr.length > 0){
            System.out.println("testResp2");
             responseBody = new String(responseBodyArr, StandardCharsets.UTF_8);
        Response response = Response.builder().body(responseBody).build();
        wrappedResponse.copyBodyToResponse();
        responseRepository.save(response);
        }
    }
}
