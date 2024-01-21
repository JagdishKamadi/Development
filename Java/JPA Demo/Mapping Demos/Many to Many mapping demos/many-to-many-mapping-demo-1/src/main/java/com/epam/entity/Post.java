package com.epam.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;

    private String postDescription;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable( name = "post_tags",
                joinColumns = { @JoinColumn(
                        name="post_id",
                        referencedColumnName = "postId")},

                inverseJoinColumns = { @JoinColumn(
                        name="tag_id",
                referencedColumnName ="tagId" )})

    private List<Tag> tags;
}
