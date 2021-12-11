package json;

import bean.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    //java对象和json的转换
    @Test
    public void test1(){
        Person person = new Person(1, "刘博好帅");

        Gson gson = new Gson();
        //toJson()方法可以把java对象转成json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);

        //fromJson()方法把json字符串转回成java对象
        //第一个参数是json字符串，第二个参数是转化回去的java数据类型
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
        
    }
    
    //java对象list集合和json的转换
    @Test
    public void test2(){
        List<Person> list = new ArrayList<>();
        
        list.add(new Person(1, "刘博"));
        list.add(new Person(2, "煤球"));
        
        Gson gson = new Gson();
        
        //将list集合转化为json字符串
        String personListJsonString = gson.toJson(list);
        System.out.println(personListJsonString);
        
        //把json字符串转换回list集合
        //需要创建一个类集成TypeToken，类型就是list类型
        List<Person> list1= gson.fromJson(personListJsonString, new PersonListType().getType());
        System.out.println(list1);
        Person person = list1.get(0);
        System.out.println(person);
    }
    
    //map集合和json的转换
    @Test
    public void test3(){
        Map<Integer, Person> map = new HashMap<>();
        
        map.put(1, new Person(1, "刘博"));
        map.put(2, new Person(2, "煤球"));
        
        Gson gson = new Gson();
        
        //把map集合转换成json字符串
        String mapJsonString = gson.toJson(map);
        System.out.println(mapJsonString);
        
        //把json字符串转换回Map集合
//        Map<Integer, Person> map2 = gson.fromJson(mapJsonString, new PersonMapType().getType());
        //可以采用匿名内部类的形式来获取Type
        Map<Integer, Person> map2 = gson.fromJson(mapJsonString, new TypeToken<Map<Integer, Person>>(){}.getType());
        System.out.println(map2);

        Person person = map2.get(1);
        System.out.println(person);
    }
}
