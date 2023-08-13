package bar.factoryProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import bar.store.GangBar;
import bar.store.Table;

public class BarBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean.getClass().getName().equals("bar.store.GangBar")) {
			GangBar gb = (GangBar)bean; // 가게 빈 가져오기
			
			// 가게의 테이블의 각 가격을 총 가게 수입에 합산
			for(Table tb : gb.getTables()) {
				gb.setTotalSell(gb.getTotalSell() + tb.getTableSum());
			}
			
			System.out.println(bean);
		}
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}
