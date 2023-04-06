package learn.aop;

import org.springframework.stereotype.Service;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-06 上午9:42 周二
 */
@Service("aopUserService")
public class UserServiceImpl implements UserService{
    @Override
    public void addUser() {
        System.out.println("执行addUser方法...");
    }
}
