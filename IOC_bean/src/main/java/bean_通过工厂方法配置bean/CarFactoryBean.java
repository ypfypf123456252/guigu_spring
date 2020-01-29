package bean_通过工厂方法配置bean;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //返回bean的对象
    @Override
    public Car getObject() throws Exception {
        return new Car(brand,5000);
    }

    //返回bean的类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
