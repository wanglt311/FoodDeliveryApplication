package demo.domain.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.geo.Point;
//import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import javax.persistence.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by vagrant on 6/20/17.
 */
@Table(name = "RESTAURANTS")
@Data
@Entity
public class RestaurantInfo {
    @Id
    @GeneratedValue
    private Long id;
    private String restaurantName;
    private String restaurantAddress;

    @OneToMany(targetEntity = MenuInfo.class, cascade = CascadeType.ALL)
    private List<MenuInfo> menuInfoList;

    //private final Point location;
    private Point location;

    public RestaurantInfo() {
        this.location = new Point(0.0, 0.0);
    }

    public RestaurantInfo(Point location) {
        this.location = location;
    }

    public RestaurantInfo(List<MenuInfo> menuInfoList) {
        this.menuInfoList = menuInfoList;
    }

    @JsonCreator
    public RestaurantInfo(@JsonProperty("latitude") double latitude,
                          @JsonProperty("longitude") double longitude) {
        this.location = new Point(longitude, latitude);//x, y
    }

    public double getLatitude() {
        return this.location.getY();
    }

    public double getlongitude() {
        return this.location.getX();
    }

    @JsonCreator
    public RestaurantInfo(@JsonProperty("restaurantName") String restaurantName,
                          @JsonProperty("restaurantAddress") String restaurantAddress,
                          @JsonProperty("latitude") double latitude,
                          @JsonProperty("longitude") double longitude,
                          @JsonProperty("menuInfo") List<MenuInfo> menuInfoList) {
        this.location = new Point(longitude, latitude);
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.menuInfoList = menuInfoList;
    }

}
