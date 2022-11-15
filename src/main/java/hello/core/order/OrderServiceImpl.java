package hello.core.order;

import hello.core.discont.DiscountPolicy;
import hello.core.discont.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();      //메모리회원레포와 고정할인정책을 구현체로 생성 사용


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //discountpolicy 가 없었다면 오더 서비스에서 할인과 관련된변경시 오더 서비스를 고쳐야한다..

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

//test

}
