package hr.kingict.springbootakademija2023.dto;

public class LocationDto {
    private String name;
    private String detailedName;
    private String iataCode;

    public LocationDto(String name, String detailedName, String iataCode) {
        this.name = name;
        this.detailedName = detailedName;
        this.iataCode = iataCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetailedName() {
        return detailedName;
    }

    public void setDetailedName(String detailedName) {
        this.detailedName = detailedName;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }
}
