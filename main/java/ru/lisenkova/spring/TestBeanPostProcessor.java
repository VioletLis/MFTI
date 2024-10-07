package ru.lisenkova.spring;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;
import ru.lisenkova.annotations.CacheHandler;

@Component
public class TestBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //if(bean.getClass().isAnnotationPresent(Default.class))
        return bean;//BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @SneakyThrows
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(new CacheHandler(bean));
        return bean;//BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
