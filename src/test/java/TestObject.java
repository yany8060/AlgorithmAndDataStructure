import org.junit.Test;

import java.util.Stack;

/**
 * Created by yanyong on 2016/12/18.
 */
public class TestObject {

    @Test
    public void testObj(){
        String a = new String("aaaa");
        Stack<String> stack =new Stack<>();
        stack.push(a);

        String b = a;

        stack.push(b);

        a = new String("bbbb");

        System.out.println(stack.pop());
        System.out.println(stack.pop());



    }

}
