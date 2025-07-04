package com.ai.plug.autoconfigure;

import com.ai.plug.autoconfigure.conditional.ConditionalOnParser;
import com.ai.plug.core.parser.des.*;
import com.ai.plug.core.parser.param.*;
import com.ai.plug.core.parser.starter.AbstractStarter;
import com.ai.plug.core.parser.starter.SingleStarter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import static com.ai.plug.common.constants.ConfigConstants.VARIABLE_PREFIX;
import static com.ai.plug.common.constants.ConfigConstants.VARIABLE_TOOL;

/**
 * @author 韩
 * time: 2025/5/16 11:40
 */
@ConditionalOnProperty(prefix = VARIABLE_PREFIX + '.' + VARIABLE_TOOL, name = ".enabled", havingValue = "true", matchIfMissing = true)
public class ToolScanConfig {
    @Bean
    public AbstractStarter starter() {
        return new SingleStarter();
    }
    @Bean
    @ConditionalOnParser(value = "MCPTOOL", type = AbstractDesParser.class)
    @Order(0)
    public AbstractDesParser mcpToolDesParser() {
        return new McpToolDesParser();
    }
    @Bean
    @ConditionalOnParser(value = "TOOL", type = AbstractDesParser.class)
    @Order(1)
    public AbstractDesParser toolDesParser() {
        return new ToolDesParser();
    }

    @Bean
    @ConditionalOnParser(value = "JACKSON", type = AbstractDesParser.class)
    @Order(2)
    public AbstractDesParser jacksonDesParser() {
        return new JacksonDesParser();
    }
    @Bean
    @ConditionalOnParser(value = "JAVADOC", type = AbstractDesParser.class)
    @Order(3)
    public AbstractDesParser javaDocDesParser() {
        return new JavaDocDesParser();
    }
    @Bean
    @ConditionalOnParser(value = "SWAGGER3", type = AbstractDesParser.class)
    @Order(4)
    public AbstractDesParser swagger3DesParser() {
        return new Swagger3DesParser();
    }
    @Bean
    @ConditionalOnParser(value = "SWAGGER2", type = AbstractDesParser.class)
    @Order(5)
    public AbstractDesParser swagger2DesParser() {
        return new Swagger2DesParser();
    }





    @Bean
    @ConditionalOnParser(value = "MCPTOOL", type = AbstractParamParser.class)
    @Order(0)
    public McpToolParamParser mcpToolParamParser() {
        return new McpToolParamParser();
    }

    @Bean
    @ConditionalOnParser(value = "TOOL", type = AbstractParamParser.class)
    @Order(1)
    public ToolParamParser toolParamParser() {
        return new ToolParamParser();
    }

    @Bean
    @ConditionalOnParser(value = "SPRINGMVC", type = AbstractParamParser.class)
    @Order(2)
    public AbstractParamParser mvcParamParser() {
        return new MvcParamParser();
    }
    @Bean
    @ConditionalOnParser(value = "JACKSON", type = AbstractParamParser.class)
    @Order(3)
    public AbstractParamParser jacksonParamParser() {
        return new JacksonParamParser();
    }

    @Bean
    @ConditionalOnParser(value = "JAVADOC", type = AbstractParamParser.class)
    @Order(4)
    public AbstractParamParser javaDocParamParser() {
        return new JavaDocParamParser();
    }
    @Bean
    @ConditionalOnParser(value = "SWAGGER3", type = AbstractParamParser.class)
    @Order(5)
    public AbstractParamParser swagger3ParamParser() {
        return new Swagger3ParamParser();
    }

    @Bean
    @ConditionalOnParser(value = "SWAGGER2", type = AbstractParamParser.class)
    @Order(6)
    public AbstractParamParser swagger2ParamParser() {
        return new Swagger2ParamParser();
    }







}
