package basics.type;


import junit.framework.TestCase;

public class TestChar extends TestCase {

    public void testValue() {
        char charLiteral = '0';
        System.out.printf("char value = '%c' \n", charLiteral);

        charLiteral = '中';
        System.out.printf("char value = '%c' \n", charLiteral);
    }

    public void testIntConversion(){
        // char --> int
        char ch = '0';
        int i = (int) ch;
        System.out.printf("char value='%s', int value=%s \n", ch, i);

        // int --> char
        ch = (char) i;
        System.out.printf("char value='%s', int value=%s \n", ch, i);
    }

    public void testStringConversion(){
        //char-->String
        char ch = 'a';
        String str = String.valueOf(ch);
        System.out.printf("char value='%s', String value=%s \n", ch, str);

        //String -->char
        ch = str.charAt(0);
        System.out.printf("char value='%s', String value=%s \n", ch, str);
    }

    /**
     * char is converted to unicode value(int) before operation.
     */
    public void testOperation(){
        char ch1 = '9';
        char ch2 = '0';

        int diff = ch1 - ch2;
        System.out.printf("'%c' - '%c' = %d \n", ch1, ch2, diff);

        int sum = ch1 + ch2;
        System.out.printf("'%c' + '%c' = %d \n", ch1, ch2, sum);

    }

    @Override
    protected void setUp() throws Exception {
        System.out.println("------------Test begin --------");
    }

    @Override
    protected void tearDown() throws Exception {
        System.out.println("------------Test end --------");
    }
}
