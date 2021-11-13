package com.example.examapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {
    private long id;
    private String date;
    private String type;
    private double way;
    private double speed;
    private double calories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return id == history.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
