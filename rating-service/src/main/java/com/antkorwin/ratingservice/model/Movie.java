package com.antkorwin.ratingservice.model;

import lombok.*;

import java.util.UUID;

/**
 * Created on 16.11.2018.
 *
 * @author Korovin Anatoliy
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private UUID id;
    private String name;
    private String genre;
}
