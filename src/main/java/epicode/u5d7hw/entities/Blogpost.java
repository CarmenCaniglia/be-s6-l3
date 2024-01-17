package epicode.u5d7hw.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "blogposts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Blogpost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
