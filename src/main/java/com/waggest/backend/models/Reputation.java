package com.waggest.backend.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "reputations")
public class Reputation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Integer reputation;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reputation that = (Reputation) o;
        return id.equals(that.id) &&
                reputation.equals(that.reputation) &&
                video.equals(that.video) &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reputation, video, user);
    }
}
