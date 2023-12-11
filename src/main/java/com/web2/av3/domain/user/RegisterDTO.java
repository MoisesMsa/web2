package com.web2.av3.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
