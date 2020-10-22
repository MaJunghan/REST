package com.example.restwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>(); // User객체란 자료형만 사용할수있다고. 리스트선언

    private static int usersCount = 3;

    static {
        users.add(new User(1,"king1",new Date(), "pass1","920329-333333"));
        users.add(new User(2,"king2",new Date(), "pass1","820329-111111"));
        users.add(new User(3,"king3",new Date(), "pass1","720329-222222"));
    }

    // 사용자 전체목록조회
    public  List<User> findAll() {
        return  users;
    }

    // 사용자 추가
    public  User save(User user) {
        if (user.getId() == null) { // 기존에 존재하는 id가 없다면
            user.setId(++usersCount); // 새로추가하면 4가됨.
        }
        users.add(user); // 그럼 4가 user에 추가가되고
        return  user; // user출력
    }

    // 사용자 개별데이터 반환
    public  User findOne(int id) { //3명의 사용자중에서 키값으로 id사용 > 매개변수
        for( User user : users) { // db가 리스트이기떄문에 리스트 users의 값을 user에담고
            if(user.getId() == id) { //담긴아이디와 받은id가 같으면 유저리턴
                return user;
            }
        }
        return null; // 만약 같은아이디값이없으면 널값출력
    }

    // 사용자 삭제
    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        // 이터레이터 : 가지고있는배열이나 리스트의 열거형데이터
        while (iterator.hasNext()) {
            User user = iterator.next(); // 가져온값을 담음

            if(user.getId() == id) { // 가져온값이과 기존값이 일치하면
                iterator.remove(); //삭제
                return user;
            }
        }
        return null; // 이결과가 실행되지않으면 null
    }
}
