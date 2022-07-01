package com.example.jpql_cs.model;

import javax.persistence.*;

@Entity
public class Cotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String codein;
    private String name;
    private String high;
    private String low;
    private String varBid;
    private String pctChange;
    private String bid;
    private String ask;
    private String timestamp;
    private String create_date;

    public Favorita getFavorita() {
        return favorita;
    }

    public void setFavorita(Favorita favorita) {
        this.favorita = favorita;
    }

    @ManyToOne
    private Favorita favorita;



    // Getter Methods

    public String getCode() {
        return code;
    }

    public String getCodein() {
        return codein;
    }

    public String getName() {
        return name;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getVarBid() {
        return varBid;
    }

    public String getPctChange() {
        return pctChange;
    }

    public String getBid() {
        return bid;
    }

    public String getAsk() {
        return ask;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getCreate_date() {
        return create_date;
    }

    // Setter Methods

    public void setCode(String code) {
        this.code = code;
    }

    public void setCodein(String codein) {
        this.codein = codein;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setVarBid(String varBid) {
        this.varBid = varBid;
    }

    public void setPctChange(String pctChange) {
        this.pctChange = pctChange;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
}
