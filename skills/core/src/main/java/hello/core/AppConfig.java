package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
   public MemberService memberService() {
       //생성자를 통해서 주입한다.
       return new MemberServiceImpl(memberRepository());
   }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
       return new OrderServiceImpl(memberRepository(), discountPolicy());
   }

    @Bean
    public DiscountPolicy discountPolicy() {
       //FixDiscountPolicy -> RateDiscountPolicy 이렇게 바꿈으로써 DI 의존성하고 OCP 지켜짐
       return new RateDiscountPolicy();
    }
}
