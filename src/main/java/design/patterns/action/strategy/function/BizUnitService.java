package design.patterns.action.strategy.function;

import org.springframework.stereotype.Service;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-14 下午2:50 周三
 */
@Service
public class BizUnitService {
    public String bizOne(String order) {
       return order+"one";
    }

    public String bizTwo(String order) {
        return order+"two";
    }

    public String bizThree(String order) {
        return order+"three";
    }
}
