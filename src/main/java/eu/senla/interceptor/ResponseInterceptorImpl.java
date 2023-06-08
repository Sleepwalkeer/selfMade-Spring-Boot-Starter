package eu.senla.interceptor;

import eu.senla.entity.Response;
import eu.senla.service.ResponseService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class ResponseInterceptorImpl extends OncePerRequestFilter implements ResponseInterceptor {

    private final ResponseService responseService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var wrappedResponse = new ContentCachingResponseWrapper(response);
            filterChain.doFilter(request, wrappedResponse);
            byte[] responseBody = wrappedResponse.getContentAsByteArray();
            if (responseBody.length > 0) {
                String responseBodyString = new String(responseBody, StandardCharsets.UTF_8);
                Response responseToSave = Response.builder().body(responseBodyString).build();
                responseService.handleResponse(responseToSave);
                wrappedResponse.copyBodyToResponse();
            }
    }
}
