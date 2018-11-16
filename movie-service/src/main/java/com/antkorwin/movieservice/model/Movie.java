package com.antkorwin.movieservice.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created on 16.11.2018.
 *
 * @author Korovin Anatoliy
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    private String name;

    private String genre;
}
