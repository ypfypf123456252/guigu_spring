package 泛型依赖注入;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends BaseRepository<User> {
}
