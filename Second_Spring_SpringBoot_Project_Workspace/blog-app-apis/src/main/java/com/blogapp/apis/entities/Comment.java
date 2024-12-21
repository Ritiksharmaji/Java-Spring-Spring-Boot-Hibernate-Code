package com.blogapp.apis.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="comments")
@NoArgsConstructor
@Getter
@Setter
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="comment_id")
	private int commentId;
	
	// Using @Lob annotation to store text data
    @Lob
	private String content;
    
    /*
     * mapping between multiple comments for a single post
     */
    @ManyToOne
    private Post post;
    
    /*
     * mapping between multiple comments for a single user.
     */
    @ManyToOne
    private User user;
    
    /*
     * mapping between multiple comments for a single category.
     */
    @ManyToOne
	private Category category;
	
}
