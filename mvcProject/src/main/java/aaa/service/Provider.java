package aaa.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class Provider implements ApplicationContextAware {
	
	ApplicationContext context;

	public ApplicationContext getContext() {
		return context;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

}
