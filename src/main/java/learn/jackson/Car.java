package learn.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-07-24 2:02 下午 周五
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Car {
    private String brand;
    private int doors;
    private Date date;

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String carJson ="{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        Car car2 = new Car("bmw", 3, new Date());
        try {
            Car car = objectMapper.readValue(carJson, Car.class);
            Map<String, Object> jsonMap = objectMapper.readValue(carJson, new TypeReference<Map<String, Object>>() {});

            System.out.println(car.toString());
            System.out.println(jsonMap.toString());

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            objectMapper.setDateFormat(dateFormat);
            String json = objectMapper.writeValueAsString(car2);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
