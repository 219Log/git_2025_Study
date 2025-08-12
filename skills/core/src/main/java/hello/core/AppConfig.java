package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /*
    call AppConfig.memberService
    call AppConfig.memberRepository
    call AppConfig.orderService
    이런식으로 뜸 테스트시 이것이 싱글톤을 보장해준다는 소리
     */


    @Bean
   public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
       //생성자를 통해서 주입한다.
       return new MemberServiceImpl(memberRepository());
   }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
       return new OrderServiceImpl(memberRepository(), discountPolicy());
   }

    @Bean
    public DiscountPolicy discountPolicy() {
       //FixDiscountPolicy -> RateDiscountPolicy 이렇게 바꿈으로써 DI 의존성하고 OCP 지켜짐
       return new RateDiscountPolicy();
    }



}
