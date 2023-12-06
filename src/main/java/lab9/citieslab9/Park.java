package lab9.citieslab9;
public class Park {
    int id, cityID, S;
    String name,date,water,type;
    @Override
    public String toString() {
        return "Park{" +
                "id=" + id +
                ", cityID=" + cityID +
                ", S=" + S +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", water=" + water +
                '}';
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCityID() {
        return cityID;
    }
    public void setCityID(int cityID) {
        this.cityID = cityID;
    }
    public int getS() {
        return S;
    }
    public void setS(int s) {
        S = s;
    }
    public String getWater() {
        return water;
    }
    public void setWater(String water) {
        this.water = water;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Park(int id, int cityID, int s, String water, String type, String name, String date) {
        this.id = id;
        this.cityID = cityID;
        this.S = s;
        this.water = water;
        this.type = type;
        this.name = name;
        this.date = date;
    }
}