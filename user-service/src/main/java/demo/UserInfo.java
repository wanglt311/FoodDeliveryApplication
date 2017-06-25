package demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by vagrant on 6/25/17.
 */

@Data
@Document
public class UserInfo {
    @Id
    private Long id;

    private String userName;

}
