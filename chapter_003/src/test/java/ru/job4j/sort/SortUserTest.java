package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenListThenSortTreeSet() {
        List<User> list = new ArrayList<>();
        User user1 = new User("1", 10 );
        User user2 = new User("2", 5 );
        User user3 = new User("3", 20);
        User user4 = new User("4", 1);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(list);
        List <User> expected = new ArrayList<>();
        expected.add(user4);
        expected.add(user2);
        expected.add(user1);
        expected.add(user3);
        assertThat(result.toArray(), is(expected.toArray()));
    }
}
