package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); //자기자신을 외부에 private로 하나 가지고잇는다. static으로(한개만존재하게된다.)
                                                                                                                        //jvm이 실행되면서 static 영역에 있는 instance를 초기화하면서, new로 SingletonService를 가진다.
    public static SingletonService getInstance() {
        return instance;    //instance의 참조를 꺼낼수있는 방법은 이곳뿐이다. 다른곳에서 new 불가능. private이기때문.
    }

   private SingletonService() {

   }

   public void logic(){
       System.out.println(" 싱글톤 객체 로직 호출");

   }
}
