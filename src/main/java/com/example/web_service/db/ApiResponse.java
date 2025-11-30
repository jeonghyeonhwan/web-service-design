package com.example.web_service.db;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private String status;
    private T data;
    private String message;
    private LocalDateTime timestamp;

    public ApiResponse(String status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>("success", data, message);
    }

    public static ApiResponse<?> error(String message) {
        return new ApiResponse<>("error", null, message);
    }

    // getters
    public String getStatus() { return status; }
    public T getData() { return data; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
