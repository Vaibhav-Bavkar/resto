package com.example.resto.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.NamedEntityGraph;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationResponse {


    private long userId;
    private String Message;
}
