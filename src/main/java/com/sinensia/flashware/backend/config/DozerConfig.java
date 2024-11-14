package com.sinensia.flashware.backend.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfig {

	@Bean(name="mapper")
	DozerBeanMapper getMapper() {
		
		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		
		// Solo si se requieren mappings "complejos"....
		
		//List<String> mappingFiles = List.of("dozer-configuration-mappings.xml");
		
		//dozerBeanMapper.setMappingFiles(mappingFiles);
		
		return  dozerBeanMapper;
	}
	
}

