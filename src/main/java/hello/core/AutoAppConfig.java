package hello.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

@Configuration
@ComponentScan(
	// basePackages = "hello.core.member",
	// @ComponentScan에서 AppConfig의 @Configuration 안에 @Component가 있어서 예제 안전하게 유지하기 위해
	excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
// 기존의 AppConfig와는 다르게 @Bean으로 등록한 클래스가 하나도 없다
public class AutoAppConfig {

	/*@Bean(name = "memoryMemberRepository")
	MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}*/
}
