package hr.kingict.springbootakademija2023.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "rezultati_letova")
public class FlightSearchResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "cijena")
    private String price;
    @Column(name = "odlazna_aviokompanija")
    private String outboundCarrier;
    @Column(name = "povratna_aviokompanija")
    private String inboundCarrier;
    @ManyToOne
    @JoinColumn(name = "pretraga_id")
    private FlightSearchEntity flightSearchEntity;
    @Column(name = "korisnik_kreiranja")
    private String userCreated;
    @Column(name = "datum_kreiranja")
    private LocalDate dateCreated;
    @Column(name = "korisnik_azuriranja")
    private String userUpdated;
    @Column(name = "datum_azuriranja")
    private LocalDate dateUpdated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightSearchResultEntity that = (FlightSearchResultEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOutboundCarrier() {
        return outboundCarrier;
    }

    public void setOutboundCarrier(String outboundCarrier) {
        this.outboundCarrier = outboundCarrier;
    }

    public String getInboundCarrier() {
        return inboundCarrier;
    }

    public void setInboundCarrier(String inboundCarrier) {
        this.inboundCarrier = inboundCarrier;
    }

    public FlightSearchEntity getFlightSearchEntity() {
        return flightSearchEntity;
    }

    public void setFlightSearchEntity(FlightSearchEntity flightSearchEntity) {
        this.flightSearchEntity = flightSearchEntity;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(String userUpdated) {
        this.userUpdated = userUpdated;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
