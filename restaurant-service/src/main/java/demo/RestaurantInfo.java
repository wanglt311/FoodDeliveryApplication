package demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @GeoSpatialIndexed
    private final Point location;

    public RestaurantInfo() {
        this.location = new Point(0.0, 0.0);
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
                          @JsonProperty("longitude") double longitude) {
        this.location = new Point(longitude, latitude);
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
    }

}
