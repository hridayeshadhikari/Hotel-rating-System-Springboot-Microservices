package com.userserviceapp.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String ratingId;
    private Long userId;
    private Long hotelId;
    private String feedback;
    private int rating;
    private Hotel hotel;
}
