package com.latelier.catmash.jwtModels;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AuthenticationResponse implements Serializable {
    private final String jwt;
}