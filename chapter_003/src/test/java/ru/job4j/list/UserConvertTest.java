package ru.job4j.list;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    @Test
    public void whenListThenMap() {
        UserConvert convert = new UserConvert();

        String name = "name";
        String city = "city";
        List<User> list = new LinkedList<User>();
        User user1 = new User(1, name, city);
        User user2 = new User(2, name, city);
        User user3 = new User(3, name, city);
        User user4 = new User(4, name, city);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        Map<Integer, User> result = convert.process(list);

        Map<Integer, User> expected = new HashMap<Integer, User>();
        User user1temp = new UserTemp(name, city);
        User user2temp = new UserTemp(name, city);
        User user3temp = new UserTemp(name, city);
        User user4temp = new UserTemp(name, city);
        expected.put(1, user1temp);
        expected.put(2, user2temp);
        expected.put(3, user3temp);
        expected.put(4, user4temp);
        assertThat(result.keySet(), is(expected.keySet()));
    }
}

