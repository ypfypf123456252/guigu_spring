package annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    public void save(){
        System.out.println("UserRepositoryImpl  Save...");
    }
}
