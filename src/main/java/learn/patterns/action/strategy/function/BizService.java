package learn.patterns.action.strategy.function;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-14 下午2:50 周三
 */
@Service
public class BizService {

    @Resource
    private BizUnitService bizUnitService;

    private Map<String, Function<String, String>> checkResult = new HashMap<>();

    @PostConstruct
    public void checkResultInit() {
        checkResult.put("key_one", order -> bizUnitService.bizOne(order));
        checkResult.put("key_two", order -> bizUnitService.bizTwo(order));
        checkResult.put("key_three", order -> bizUnitService.bizThree(order));
    }

    public String getCheckResult(String order) {
        String key = this.getKey(order);
        Function<String, String> result = this.checkResult.get(key);
        return Optional.ofNullable(result.apply(order)).orElse("不在处理的逻辑中返回业务错误");
    }

    private String getKey(String order) {
        return "key_"+order;
    }

}
