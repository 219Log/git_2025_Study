package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//설정 정보니까 써주고
@Configuration
//스프링빈을 자동으로 끌어옴  @어노테이션 빈 전부 끌어옴
@ComponentScan(
        //Configuration 정보가보면 컴포넌트로 되어있음
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

  /*  @Bean(name = "memorMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/




}
