package hello.core;

import hello.core.discont.DiscountPolicy;
import hello.core.discont.FixDiscountPolicy;
import hello.core.discont.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

        public MemberService    memberService(){    //어딘가에서 memberService를 사용하면 Memory멤버레포가 주입된다. 생성자주입이다.
            return new MemberServiceImpl(memberRepository());
        }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();        //  메모리 멤버 레포를 사용.  나중에 jdbc레포를 사용하고싶다면 이부분만 변경하면 된다.
    }

    public OrderService orderService(){     //orderService를 조회하면 메모리멤버레포, 픽스디스카운트가 리턴
            return new OrderServiceImpl(memberRepository(),  discountPolicy());
        }

        public DiscountPolicy discountPolicy() {
            return new RateDiscountPolicy();
//            return new FixDiscountPolicy();
    }
}

//appconfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
//appconfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.
