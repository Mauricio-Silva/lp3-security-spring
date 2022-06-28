package br.com.ifms.tads5.lp3securityspring.javabeans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Artist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<License> licenses;
}
