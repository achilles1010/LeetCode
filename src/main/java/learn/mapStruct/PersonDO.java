package learn.mapStruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-08-11 2:55 下午 周二
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDO {
    private Integer id;
    private String name;
    private int age;
    private Date birthday;
    private String gender;

    public static void main(String[] args) {
        PersonDO personDO = new PersonDO(1, "dai", 22, new Date(), "male");
        PersonDTO personDTO = PersonConverter.INSTANCE.do2dto(personDO);
        System.out.println(personDTO);
    }
}
