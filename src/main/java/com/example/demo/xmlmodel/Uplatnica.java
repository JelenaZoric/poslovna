//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.09 at 03:00:38 PM CEST 
//


package com.example.demo.xmlmodel;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}podaciODuzniku"/>
 *         &lt;element ref="{}racunDuznika"/>
 *         &lt;element ref="{}podaciOPoveriocu"/>
 *         &lt;element ref="{}racunPoverioca"/>
 *         &lt;element ref="{}svrhaPlacanja"/>
 *         &lt;element ref="{}sifraPlacanja"/>
 *         &lt;element ref="{}iznos"/>
 *         &lt;element ref="{}modelZaduzenja"/>
 *         &lt;element ref="{}pozivNaBrojZaduzenja"/>
 *         &lt;element ref="{}modelOdobrenja"/>
 *         &lt;element ref="{}pozivNaBrojOdobrenja"/>
 *         &lt;element ref="{}hitno"/>
 *         &lt;element ref="{}datumPrijema"/>
 *         &lt;element ref="{}datumValute"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "podaciODuzniku",
    "racunDuznika",
    "podaciOPoveriocu",
    "racunPoverioca",
    "svrhaPlacanja",
    "sifraPlacanja",
    "iznos",
    "modelZaduzenja",
    "pozivNaBrojZaduzenja",
    "modelOdobrenja",
    "pozivNaBrojOdobrenja",
    "hitno",
    "datumPrijema",
    "datumValute"
})
@XmlRootElement(name = "uplatnica")
public class Uplatnica {

    @XmlElement(required = true)
    protected PodaciODuzniku podaciODuzniku;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String racunDuznika;
    @XmlElement(required = true)
    protected PodaciOPoveriocu podaciOPoveriocu;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String racunPoverioca;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String svrhaPlacanja;
    @XmlElement(required = true)
    protected BigInteger sifraPlacanja;
    @XmlElement(required = true)
    protected BigDecimal iznos;
    @XmlElement(required = true)
    protected BigInteger modelZaduzenja;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String pozivNaBrojZaduzenja;
    @XmlElement(required = true)
    protected BigInteger modelOdobrenja;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String pozivNaBrojOdobrenja;
    protected boolean hitno;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPrijema;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumValute;

    /**
     * Gets the value of the podaciODuzniku property.
     * 
     * @return
     *     possible object is
     *     {@link PodaciODuzniku }
     *     
     */
    public PodaciODuzniku getPodaciODuzniku() {
        return podaciODuzniku;
    }

    /**
     * Sets the value of the podaciODuzniku property.
     * 
     * @param value
     *     allowed object is
     *     {@link PodaciODuzniku }
     *     
     */
    public void setPodaciODuzniku(PodaciODuzniku value) {
        this.podaciODuzniku = value;
    }

    /**
     * Gets the value of the racunDuznika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRacunDuznika() {
        return racunDuznika;
    }

    /**
     * Sets the value of the racunDuznika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRacunDuznika(String value) {
        this.racunDuznika = value;
    }

    /**
     * Gets the value of the podaciOPoveriocu property.
     * 
     * @return
     *     possible object is
     *     {@link PodaciOPoveriocu }
     *     
     */
    public PodaciOPoveriocu getPodaciOPoveriocu() {
        return podaciOPoveriocu;
    }

    /**
     * Sets the value of the podaciOPoveriocu property.
     * 
     * @param value
     *     allowed object is
     *     {@link PodaciOPoveriocu }
     *     
     */
    public void setPodaciOPoveriocu(PodaciOPoveriocu value) {
        this.podaciOPoveriocu = value;
    }

    /**
     * Gets the value of the racunPoverioca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRacunPoverioca() {
        return racunPoverioca;
    }

    /**
     * Sets the value of the racunPoverioca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRacunPoverioca(String value) {
        this.racunPoverioca = value;
    }

    /**
     * Gets the value of the svrhaPlacanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvrhaPlacanja() {
        return svrhaPlacanja;
    }

    /**
     * Sets the value of the svrhaPlacanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvrhaPlacanja(String value) {
        this.svrhaPlacanja = value;
    }

    /**
     * Gets the value of the sifraPlacanja property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSifraPlacanja() {
        return sifraPlacanja;
    }

    /**
     * Sets the value of the sifraPlacanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSifraPlacanja(BigInteger value) {
        this.sifraPlacanja = value;
    }

    /**
     * Gets the value of the iznos property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIznos() {
        return iznos;
    }

    /**
     * Sets the value of the iznos property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIznos(BigDecimal value) {
        this.iznos = value;
    }

    /**
     * Gets the value of the modelZaduzenja property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getModelZaduzenja() {
        return modelZaduzenja;
    }

    /**
     * Sets the value of the modelZaduzenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setModelZaduzenja(BigInteger value) {
        this.modelZaduzenja = value;
    }

    /**
     * Gets the value of the pozivNaBrojZaduzenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPozivNaBrojZaduzenja() {
        return pozivNaBrojZaduzenja;
    }

    /**
     * Sets the value of the pozivNaBrojZaduzenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPozivNaBrojZaduzenja(String value) {
        this.pozivNaBrojZaduzenja = value;
    }

    /**
     * Gets the value of the modelOdobrenja property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getModelOdobrenja() {
        return modelOdobrenja;
    }

    /**
     * Sets the value of the modelOdobrenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setModelOdobrenja(BigInteger value) {
        this.modelOdobrenja = value;
    }

    /**
     * Gets the value of the pozivNaBrojOdobrenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPozivNaBrojOdobrenja() {
        return pozivNaBrojOdobrenja;
    }

    /**
     * Sets the value of the pozivNaBrojOdobrenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPozivNaBrojOdobrenja(String value) {
        this.pozivNaBrojOdobrenja = value;
    }

    /**
     * Gets the value of the hitno property.
     * 
     */
    public boolean isHitno() {
        return hitno;
    }

    /**
     * Sets the value of the hitno property.
     * 
     */
    public void setHitno(boolean value) {
        this.hitno = value;
    }

    /**
     * Gets the value of the datumPrijema property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPrijema() {
        return datumPrijema;
    }

    /**
     * Sets the value of the datumPrijema property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPrijema(XMLGregorianCalendar value) {
        this.datumPrijema = value;
    }

    /**
     * Gets the value of the datumValute property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumValute() {
        return datumValute;
    }

    /**
     * Sets the value of the datumValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumValute(XMLGregorianCalendar value) {
        this.datumValute = value;
    }

}
