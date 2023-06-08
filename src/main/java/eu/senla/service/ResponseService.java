package eu.senla.service;

import jakarta.servlet.http.HttpServletResponse;

public interface ResponseService {

    void handleResponse(HttpServletResponse httpServletResponse);
}
