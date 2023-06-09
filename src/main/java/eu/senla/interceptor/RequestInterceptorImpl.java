package eu.senla.interceptor;

import eu.senla.service.RequestService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class RequestInterceptorImpl extends OncePerRequestFilter implements RequestInterceptor {

    private final RequestService requestService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       requestService.handleRequest(request);
       filterChain.doFilter(request, response);

    }
}
