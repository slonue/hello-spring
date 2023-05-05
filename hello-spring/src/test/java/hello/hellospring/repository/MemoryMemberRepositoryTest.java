package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();


    @Test
        public void save(){
            Member member = new Member();
            member.setName("spring");

            repository.save(member);
            Member result = repository.findById(member.getId()).get();
            //db에서 꺼낸거랑 메모리에서 꺼낸거랑 같으면  결과랑 멤버랑 같냐?
            // System.out.println("result =" +(result ==member));
           //Assertions.assertEquals(result,member); //저장했던 멤버가 find했을때 튀어놔야  함
             assertThat(member).isEqualTo(result);
        }



    @Test
    public void findByName(){
        Member member1 = new Member ();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
     public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);


        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
