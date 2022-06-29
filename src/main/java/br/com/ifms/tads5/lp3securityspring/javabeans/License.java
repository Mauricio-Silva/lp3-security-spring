package br.com.ifms.tads5.lp3securityspring.javabeans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class License {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String type;

    @NotEmpty
    @Column(unique = true)
    private String ownername;

    @NotEmpty
    @JsonIgnore
    private String password;

    private boolean is_accredited = true;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_artist")
    private Artist artist;
}
