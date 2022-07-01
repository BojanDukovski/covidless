package app.covidless.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keywords;

    private String content;

    private Double rating;

    @OneToOne
    private AppUser user;

    public Post(){}

    public Post(String keywords, String content, Double rating, AppUser user){
        this.keywords = keywords;
        this.content = content;
        this.rating = rating;
        this.user = user;
    }

}
