package com.example.springboot.jpa.oneToMany;

import com.example.springboot.jpa.manyToOne.DeclarationDetail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "declaration_master")
@NoArgsConstructor
public class Declaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false)
    private Long seqId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "declaration")
    private Set<DeclarationDetail> declarationDetails = new HashSet<>();

    @Column(name = "decl_form_no", nullable = false, length = 16)
    private String declareFormNo;

    @Column(name = "decl_nm", nullable = false)
    private String declareTypeName;

    public void addDeclarationDetail(List<DeclarationDetail> declarationDetails) {
        this.declarationDetails = new HashSet<>();
        this.declarationDetails.addAll(declarationDetails);
    }


}