package design.patterns.action.strategy.lambda;

/**
 * The interface Pay strategy.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-03 10:45 上午 周三
 */
public class Validator {
    private ValidateStrategy validateStrategy;

    /**
     * Instantiates a new Validator.
     *
     * @param validateStrategy the validate strategy
     */
    public Validator(ValidateStrategy validateStrategy) {
        this.validateStrategy = validateStrategy;
    }

    /**
     * Validate boolean.
     *
     * @param s the s
     * @return the boolean
     */
    public boolean validate(String s) {
        return validateStrategy.execute(s);
    }

    public static void main(String[] args) {
        Validator validator = new Validator(new IsNumeric());
        System.out.println(validator.validate("79834"));


        Validator validator1 = new Validator(new IsAllowLowerCase());
        System.out.println(validator1.validate("kdfadf"));

        // 匿名内部类
        Validator validator2 = new Validator(new ValidateStrategy() {
            @Override
            public boolean execute(String s) {
                return s.matches("[A-Z]+");
            }
        });
        System.out.println(validator2.validate("AAADDD"));

        // 函数编程 lambda表达
        Validator validator3 = new Validator(s -> s.matches("[a-z]+"));
        System.out.println(validator3.validate("sadfsdf"));

        // 函数编程 lambda表达
        Validator validator4 = new Validator(s -> s.matches("\\d+"));
        System.out.println(validator4.validate("1111"));
    }
}
