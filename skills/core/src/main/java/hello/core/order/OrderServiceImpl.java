package hello.core.order;

import hello.core.annotation.MainDiscountPolcy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor  //생성자를 만들어줌 롬복 제공  //오토와이어같은것
public class OrderServiceImpl implements OrderService {
    //수정이 필요 없어진 코드가 되어짐 appConfig만 구현객체를 생성한다
    //여기는 실행하는 역할이고 config는 실행하는 역할임
    //여기는 어느배우가와도 연기를 해야하는배우 역할
     private final MemberRepository memberRepository;
    //클라이언트 코드 손안대서 좋다..
     private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        /*@Qualifier("mainDiscountPolicy") 여기는 픽스(프라이머리보다 쿼리파이어가 더 우선) @MainDiscountPolcy*/
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용
    public MemberRepository getMemberRepository() {

        return memberRepository;
    }
}
