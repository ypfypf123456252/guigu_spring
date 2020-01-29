package 泛型依赖注入;

import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {
}
