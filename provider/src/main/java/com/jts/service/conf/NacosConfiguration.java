package com.jts.service.conf;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.StandardEnvironment;

@Configuration
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
@NacosPropertySource(dataId = "provider.yaml", autoRefreshed = true, type = ConfigType.YAML,
        before = StandardEnvironment.SYSTEM_PROPERTIES_PROPERTY_SOURCE_NAME,
        after = StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME)
public class NacosConfiguration {

}
