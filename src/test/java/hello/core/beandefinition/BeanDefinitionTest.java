package hello.core.beandefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import hello.core.AppConfig;

public class BeanDefinitionTest {

	// AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

	@Test
	@DisplayName("빈 설정 메타정보 확인")
	void findApplicationBean() {
		// ApplicationContext는 getBeanDefinitionNames()를 사용 x
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("beanDefinitionNAme = " + beanDefinitionName +
					" beanDefinition = " + beanDefinition);
			}
		}
	}
}
