package com.ai.plug.core.register.tool;

import com.ai.plug.core.context.ToolContext;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;


/**
 * @author: han
 * time: 2025/04/2025/4/10 15:49
 * des:
 */

public class ClassPathToolScanner extends ClassPathBeanDefinitionScanner {

    private final ToolContext.ToolRegisterDefinition toolRegisterDefinition;

    public ClassPathToolScanner(BeanDefinitionRegistry registry, ToolContext.ToolRegisterDefinition toolRegisterDefinition) {
        super(registry, false);
        this.toolRegisterDefinition = toolRegisterDefinition;
        super.setBeanNameGenerator(new ToolBeanNameGenerator());
    }


    public class ToolBeanNameGenerator extends AnnotationBeanNameGenerator {
        public ToolBeanNameGenerator() {
        }

        @Override
        public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
            String beanName = super.generateBeanName(definition, registry);

            ToolContext.addTool(beanName, toolRegisterDefinition);

            return beanName;
        }
    }


}
