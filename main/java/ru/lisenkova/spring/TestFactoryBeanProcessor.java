package ru.lisenkova.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class TestFactoryBeanProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) /*throws BeansException*/ {
        if (!beanFactory.containsBean("random"))
        {

            DefaultListableBeanFactory context =
                    new DefaultListableBeanFactory();
            GenericBeanDefinition bdf = new GenericBeanDefinition();
            bdf.setBeanClassName("ru.lisenkova.spring.Random");
            bdf.setScope("prototype");
            BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
           // registry.registerBeanDefinition("random", BeanDefinitionBuilder.rootBeanDefinition(Random.class)
           //         .getBeanDefinition());
            //context.registerBeanDefinition("random", bdf);
            ((DefaultListableBeanFactory) beanFactory)
                .registerBeanDefinition("random", bdf);
        }

    }
}
