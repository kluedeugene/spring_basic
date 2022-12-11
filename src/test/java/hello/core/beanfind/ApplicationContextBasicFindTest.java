package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//스태틱 import (alt + enter )
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);     //검증.  memberSerivce가 memverServiceImpl의 인스턴스인가?
        //         System.out.println("memberService = " + memberService);
        //        System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);     //검증.  memberSerivce가 memverServiceImpl의 인스턴스인가?
    }

    @Test
    @DisplayName("구체 타입으로만 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService",MemberServiceImpl.class);  //역활과 구현에 어긋나는 방식
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);     //검증.  memberSerivce가 memverServiceImpl의 인스턴스인가?
    }

    @Test
    @DisplayName(" 빈 이름으로 조회 X")
    void findBeanByNameX(){
//        ac.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,               //예외 테스트
                () -> ac.getBean("xxxx", MemberService.class));
    }
}
