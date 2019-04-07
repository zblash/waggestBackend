package com.waggest.backend.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "categories")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd-M-yyyy")
    private Date createdAt;

    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
    private List<User> users;

    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Video> videos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id.equals(category.id) &&
                name.equals(category.name) &&
                createdAt.equals(category.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt);
    }
}
