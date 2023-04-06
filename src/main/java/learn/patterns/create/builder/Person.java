package learn.patterns.create.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Music player.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 4:54 下午 周五
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private String sex;
    private String country;

    @Data
    public static class Builder {
        private String name;
        private int age;
        private String sex;
        private String country;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }
        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Person create() {
            return new Person(name, age, sex, country);
        }
    }

    public static void main(String[] args) {
        Person person = new Person.Builder().setAge(14).setCountry("CHINA").setSex("male").setName("test").create();
        System.out.println(person.toString());
    }
}
