package com.automata.testing.framework.post.config;

import com.automata.testing.framework.algorithm.service.DecrypteRotation13ServiceImpl;
import com.automata.testing.framework.algorithm.service.EncrypteRotation13ServiceImpl;
import com.automata.testing.framework.algorithm.service.IDecryptionService;
import com.automata.testing.framework.algorithm.service.IEncryptionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InjectionConfiguration {

  @Bean
  public IEncryptionService getEncryptionService() {
    return new EncrypteRotation13ServiceImpl();
  }

  @Bean
  public IDecryptionService getDecryptionService() {
    return new DecrypteRotation13ServiceImpl();
  }
}
