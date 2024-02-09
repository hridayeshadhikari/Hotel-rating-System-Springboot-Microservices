package com.ratingserviceapp.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("User_Rating")
public class Rating {

    @Id
    private String ratingId;
    private Long userId;
    private Long hotelId;
    private int rating;
    private String feedback;
}
