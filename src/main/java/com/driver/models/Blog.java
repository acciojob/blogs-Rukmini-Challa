package com.driver.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private String title;
    private Date pubishedDate;
    @ManyToOne
    @JoinColumn
    User user;
    @OneToMany(mappedBy ="blog",cascade = CascadeType.ALL)
    List<Image> images = new ArrayList<>();


}