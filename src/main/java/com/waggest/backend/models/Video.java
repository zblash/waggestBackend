package com.waggest.backend.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String url;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd-M-yyyy")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User addedBy;

    @OneToMany(mappedBy = "video",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Comment> comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return id.equals(video.id) &&
                url.equals(video.url) &&
                createdAt.equals(video.createdAt) &&
                category.equals(video.category) &&
                addedBy.equals(video.addedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, createdAt, category, addedBy);
    }
}
