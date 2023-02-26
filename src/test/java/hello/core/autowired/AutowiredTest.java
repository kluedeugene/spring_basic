package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(Member noBeam1) {
            System.out.println("noBeam1 = " + noBeam1);
        }


        @Autowired
        public void setNoBean2(@Nullable Member noBeam2) {
            System.out.println("noBeam2 = " + noBeam2);
        }


        @Autowired
        public void setNoBean3(Optional<Member> noBeam3) {
            System.out.println("noBeam13= " + noBeam3);
        }
    }

}
