package hello.core.order;

import hello.core.discont.DiscountPolicy;
import hello.core.discont.FixDiscountPolicy;
import hello.core.discont.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //생성자
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {

        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//DIP를 지키기위해 인터페이스만 남겨놓으면 당연하게도 안된다. 해결하려면 누군가가 Impl에 DisCountPolicy의 구현객체를 대신 생성하고주입해줘야 한다.

//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();      //메모리회원레포와 고정할인정책을 구현체로 생성 사용 OrderServiceImpl이 discountPolicy뿐만 아니라
                                                                                                                                    // FixDiscountPolicy도 함께 의존하고있다. DIP위반
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();      //비율할인정책으로 코드를 변경해야했다.  OCP 위반


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //discountpolicy 가 없었다면 오더 서비스에서 할인과 관련된변경시 오더 서비스를 고쳐야한다..

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

//테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
