package br.com.lab.impacta.account.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_Id")
    private Person customer;



    private Double balance;


    public boolean debit(Double valueDebit){

        if(this.getBalance() < valueDebit){
            return false;
        }

        Double debitAmount = this.getBalance() - valueDebit;
        this.setBalance(debitAmount);
        return true;
    }


}
