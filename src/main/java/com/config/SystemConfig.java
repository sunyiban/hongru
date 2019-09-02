package com.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;



/**
 * @autor sunyiban
 * @date 2019/9/2 10:06
 * @descrpition
 */
@Configuration
@ConfigurationProperties(prefix = "system")
public class SystemConfig {
    private Setting setting;
    private Security security;

    @Getter
    @Setter
    public static class Setting {
        private String name;
    }

    @Getter
    @Setter
    public static class Security {
        private Sign sign;
        private Auth auth;
    }


    @Getter
    @Setter
    public static class Sign {
        private boolean enabled;

        private String exclusions;

        private String rsaPublicKey;

        private String rsaPrivateKey;
    }

    @Getter
    @Setter
    public static class Auth {
        private boolean enabled;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }
}
