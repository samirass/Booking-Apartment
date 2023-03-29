package entity;

public class Flat {
    private String country;
    private String city;
    private String address;
    private String flatID;
    private Double area;
    private Double pricePerDay;
    private String tariff;
    //kvartiraning holati
    private Double days;
    //qancha kunga qolishi
    private Boolean booked = false;
    //kvartira ijaraga olinganmi yoqmi bildiradi, true = olingan , false = olinmagan
    public Flat() {}

    public Flat(String country, String city, String address, String flatID, Double area, Double price, String tariff, Double days, Boolean booked) {
        this.country = country;
        this.city = city;
        this.address = address;
        this.flatID = flatID;
        this.area = area;
        this.pricePerDay = price;
        this.tariff = tariff;
        this.days = days;
        this.booked = booked;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFlatID() {
        return flatID;
    }

    public void setFlatID(String flatID) {
        if (flatID.matches("[0-9]"))
        this.flatID = flatID;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        if (area > 0)
        this.area = area;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        if (pricePerDay >= 0)
        this.pricePerDay = pricePerDay;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public Boolean getBooked() {
        return booked;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
    }

    public Double getDays() {
        return days;
    }

    public void setDays(Double days) {
        if (days >= 0)
        this.days = days;
    }


    @Override
    public String toString() {
        return "Flat{" +
                "country ='" + country + '\'' +
                ", city ='" + city + '\'' +
                ", address ='" + address + '\'' +
                ", flatID ='" + flatID + '\'' +
                ", area =" + area +
                ", price per day =" + pricePerDay +
                ", tariff =" + tariff +
                ", days =" + days +
                ", booked=" + booked +
                '}';
    }
}
