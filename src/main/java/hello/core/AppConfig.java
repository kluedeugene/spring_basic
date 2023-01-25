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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration      // configuration을 안하면 싱글톤이 깨지고 memberRepository가 중복호출된다. -> configuration test 로 확인가능
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    //싱글톤이 깨지는 구조 아닌가? ?

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //실제론
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService



    @Bean
        public MemberService    memberService(){    //어딘가에서 memberService를 사용하면 Memory멤버레포가 주입된다. 생성자주입이다.
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
        }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();        //  메모리 멤버 레포를 사용.  나중에 jdbc레포를 사용하고싶다면 이부분만 변경하면 된다.
    }
    @Bean
    public OrderService orderService(){     //orderService를 조회하면 메모리멤버레포, 픽스디스카운트가 리턴
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),  discountPolicy());
        }

    @Bean
    public DiscountPolicy discountPolicy() {
            return new RateDiscountPolicy();
//            return new FixDiscountPolicy();
    }
}

//appconfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
//appconfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.

// configuration, bean -> 스프링 컨테이너에 등록하기위함.
