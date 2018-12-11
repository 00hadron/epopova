package ru.job4j.list;
/**
 * Конвертация списка в HashMap.
 * @author epopova
 * @since 10.12.2018
 * @version $Id$
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {

    /**
     * принимает в себя список пользователей и конвертирует его в Map с ключом Integer id и соответствующим ему User.
     * @param list
     * @return
     */
    public Map<Integer, User> process(List<User> list) {
        Map<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(),user);
        }
        return result;
    }
}
