package com.example.examapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    @NotBlank
    @Pattern(regexp = "male|female" )
    private String gender;
    @NotBlank
    @Size(min = 3, max = 16)
    private String name;
    @Min(value = 15)
    @Max(value = 99)
    private int age;
    @NotBlank
    @Size(min = 3, max = 16)
    private String password;
    @Email
    private String email;
    @Min(value = 100)
    @Max(value = 250)
    private int height;
    @Min(value = 40)
    @Max(value = 200)
    private int weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
