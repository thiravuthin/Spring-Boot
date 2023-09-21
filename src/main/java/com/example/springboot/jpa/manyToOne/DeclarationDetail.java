package com.example.springboot.jpa.manyToOne;


import com.example.springboot.jpa.oneToMany.Declaration;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "declaration_detail")
@NoArgsConstructor
public class DeclarationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sd", nullable = false)
    private Long seqId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sid_pk", nullable = false)
    private Declaration declaration;

    @Builder
    public DeclarationDetail(Long seqId, Declaration declaration) {
        this.seqId = seqId;
        this.declaration = declaration;
    }
}