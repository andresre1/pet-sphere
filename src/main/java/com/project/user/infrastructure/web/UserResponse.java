package com.project.user.infrastructure.web;

import java.time.LocalDateTime;

public record UserResponse(
    String id, String name, String email, String phone, String userType, LocalDateTime createdAt) {}
