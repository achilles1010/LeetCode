package mapStruct;

import lombok.Data;

import java.util.Date;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-08-11 2:55 下午 周二
 */
@Data
//@AllArgsConstructor
public class PersonDTO {
    private String userName;
    private Integer age;
    private Date birthday;
    private String gender;
}
