package com.example.springboot.feature.auth.domain;


import com.example.springboot.global.CreatableEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sllr_comp_info")
@DynamicInsert
@DynamicUpdate
@Where(clause = "del_yn = 'N'")
public class SellerCompanyInfo extends CreatableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private Long id;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "po_id")
    //private POSCompanyInfo posCompany;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sellerCompanyInfo")
    //private List<PdfForm> pdfForm;

    @Column(name = "SLLR_TAXCD",length = 40, nullable = false)
    private String sellerCompanyTaxCode;

    @Column(name = "pos_key",length = 5)
    private String posKey;

    @Column(name = "comp_nm",length = 400, nullable = false)
    private String companyLocalName;

    @Column(name = "comp_enm",length = 200)
    private String companyEnglishName;

    @Column(name = "rppr_name",length = 100, nullable = false)
    private String representativeName;

    @Column(name = "comp_addr",length = 400, nullable = false)
    private String companyAddress;

    @Column(name = "tel_no",length = 100)
    private String telephoneNumber;

    @Column(name = "fax_no",length = 30)
    private String faxNumber;

    @Column(name = "comp_eml",length = 100)
    private String companyEmail;

    @Column(name = "comp_logo",length = 500)
    private String companyLogo;

    @Column(name = "ntnl_cd", length = 2)
    private String nationalCode;

    @Column(name = "city_cd", length = 4)
    private String cityCode;

    @Column(name = "reg_id",length = 100)
    private String registerId;

    @Column(name = "mod_id",length = 100)
    private String modifyId;

    //@Column(name = "mod_dtm", length = Constants.DATETIME_LENGTH)
    //private String modifyDateTime;

    //@Column(name = "del_yn", length = 1)
    //@Convert(converter = YesOrNo.Converter.class)
    //@ColumnDefault("'N'")
    //private YesOrNo delYn;

    @Column(name = "txof_id", length = 5)
    private String taxOfficeId;

    @Column(name = "txof_nm", length = 100)
    private String taxOfficeName;

    @Column(name = "ACC_NO", length = 50)
    private String accountNo1;

    @Column(name = "BANK_NM", length = 400)
    private String bankName1;

    @Column(name = "ACC_NO2", length = 50)
    private String accountNo2;

    @Column(name = "BANK_NM2", length = 400)
    private String bankName2;

    //@ElementCollection
    //@CollectionTable(name = "svc_cont", joinColumns = @JoinColumn(name = "comp_id"))
    //private List<ServiceContract> serviceContracts;

//    @ElementCollection
//    @CollectionTable(name = "comp_token", joinColumns = @JoinColumn(name = "comp_id"))
//    private List<CompanyToken> companyTokens;

   //@ElementCollection
   //@CollectionTable(name = "sllr_seri_no", joinColumns = @JoinColumn(name = "comp_id"))
   //private List<SellerSerialNo> sellerSerialNos;

   //@ElementCollection
   //@CollectionTable(name = "einvoice_ticket", joinColumns = @JoinColumn(name = "comp_id"))
   //private List<InvoiceTicket> invoiceTickets;

   //@ElementCollection
   //@CollectionTable(name = "invo_no", joinColumns = @JoinColumn(name = "comp_id"))
   //private List<InvoiceNo> invoiceNos;
   @Builder(toBuilder = true)
    public SellerCompanyInfo(Long id, String sellerCompanyTaxCode, String posKey, String companyLocalName, String companyEnglishName, String representativeName, String companyAddress, String telephoneNumber, String faxNumber, String companyEmail, String companyLogo, String nationalCode, String cityCode, String registerId, String modifyId, String taxOfficeId, String taxOfficeName, String accountNo1, String bankName1, String accountNo2, String bankName2) {
        this.id = id;
        this.sellerCompanyTaxCode = sellerCompanyTaxCode;
        this.posKey = posKey;
        this.companyLocalName = companyLocalName;
        this.companyEnglishName = companyEnglishName;
        this.representativeName = representativeName;
        this.companyAddress = companyAddress;
        this.telephoneNumber = telephoneNumber;
        this.faxNumber = faxNumber;
        this.companyEmail = companyEmail;
        this.companyLogo = companyLogo;
        this.nationalCode = nationalCode;
        this.cityCode = cityCode;
        this.registerId = registerId;
        this.modifyId = modifyId;
        this.taxOfficeId = taxOfficeId;
        this.taxOfficeName = taxOfficeName;
        this.accountNo1 = accountNo1;
        this.bankName1 = bankName1;
        this.accountNo2 = accountNo2;
        this.bankName2 = bankName2;
    }



    public SellerCompanyInfo(Long id) {
        this.id = id;
    }
}