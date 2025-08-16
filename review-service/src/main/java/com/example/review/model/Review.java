
package com.example.review.model;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long entityId;
    private String entityType;
    private int rating;
    private String comment;
    // getters/setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getEntityId(){return entityId;}
    public void setEntityId(Long e){this.entityId=e;}
    public String getEntityType(){return entityType;}
    public void setEntityType(String t){this.entityType=t;}
    public int getRating(){return rating;}
    public void setRating(int r){this.rating=r;}
    public String getComment(){return comment;}
    public void setComment(String c){this.comment=c;}
}
