package com.ex.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="BLOG_POSTS")
public class Post{
    @Id
    @Column(name="POST_ID")
    @SequenceGenerator(name="POST_SEQ_GEN",sequenceName="POST_SEQ")
    @GeneratedValue(generator="U_SEQ_GEN", strategy=GenerationType.SEQUENCE)
    private int id;

    @Size(max=60)
    private String subject;
    
    @Column(nullable=false)
    private String body;

    @ManyToOne(fetch=FetchType.EAGER,cascade.ALL)
    @JoinColumn(name="AUTHOR_ID")
    private String author;

    
    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return String return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return String return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

}