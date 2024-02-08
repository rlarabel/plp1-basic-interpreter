package test;

import org.junit.Test;

import main.PLp1;

import static org.junit.Assert.assertEquals;


public class test_all {
    @Test
    public void numTest1() {
        assertEquals(PLp1.interpret("2"), "2");
    }

    @Test
    public void numTest2() {
        assertEquals(PLp1.interpret("2.1"), "2.1");
    }

    @Test
    public void boolTest() {
        assertEquals(PLp1.interpret("false"), "false");
    }

    @Test
    public void stringTest() {
        assertEquals(PLp1.interpret("'Hi'"), "'Hi'");
    }

    @Test
    public void listTest1() {
        assertEquals(PLp1.interpret("[1,2]").replaceAll("\\s",""), "[1,2]");
    }

    @Test
    public void listTest2() {
        assertEquals(PLp1.interpret("[1,[2, 3], 4]").replaceAll("\\s",""), "[1,[2,3],4]");
    }
    @Test
    public void addTest() {
        assertEquals(PLp1.interpret("2+3"), "5");
    }

    @Test
    public void andTest() {
        assertEquals(PLp1.interpret("true&false"),"false");
    }

    @Test
    public void arithTest1() {
        assertEquals(PLp1.interpret("4 + 5 * 6 - 10 / 2"),"29");
    }

    @Test
    public void arithTest2() {
        assertEquals(PLp1.interpret("4.2 + 5.33 * 6.7 - 11.0 / 2.2"),"34.911");
    }

    @Test
    public void divTest() {
        assertEquals(PLp1.interpret("2/3"),"0");
    }

    @Test
    public void eqTest() {
        assertEquals(PLp1.interpret("2==3"),"false");
    }
    
    @Test
    public void gtTest() {
        assertEquals(PLp1.interpret("2>3"),"false");
    }

    @Test
    public void geTest() {
        assertEquals(PLp1.interpret("2>=3"),"false");
    }

    @Test
    public void ltTest() {
        assertEquals(PLp1.interpret("2<3"),"true");
    }

    @Test
    public void leTest() {
        assertEquals(PLp1.interpret("2<=3"),"true");
    }

    @Test
    public void mulTest() {
        assertEquals(PLp1.interpret("2*3"),"6");
    }

    @Test
    public void subTest() {
        assertEquals(PLp1.interpret("2-3"),"-1");
    }

    @Test
    public void neTest() {
        assertEquals(PLp1.interpret("2!=3"),"true");
    }

    @Test
    public void notTest() {
        assertEquals(PLp1.interpret("!true"),"false");
    }

    @Test
    public void orTest() {
        assertEquals(PLp1.interpret("true|false"),"true");
    }

    @Test
    public void ifTest1() {
        assertEquals(PLp1.interpret("if false then 1 else 2 endif"),"2");
    }

    @Test
    public void ifTest2() {
        assertEquals(PLp1.interpret("if true then 1 else 2 endif"),"1");
    }

    @Test
    public void emptyTest1() {
        assertEquals(PLp1.interpret("emptyp->([1,2,3])"),"false");
    }

    @Test
    public void emptyTest2() {
        assertEquals(PLp1.interpret("emptyp->([])"),"true");
    }

    @Test
    public void equalTest1() {
        assertEquals(PLp1.interpret("equalp->([2,3],[2,3]))"),"true");
    }

    @Test
    public void equalTest2() {
        assertEquals(PLp1.interpret("equalp->([2,1],[2,3])"),"false");
    }

    @Test
    public void equalTest3() {
        assertEquals(PLp1.interpret("equalp->([2,[3,1]],[2,[3,1]])"),"true");
    }

    @Test
    public void equalTest4() {
        assertEquals(PLp1.interpret("equalp->([2,[3,1]],[2,[3],1])"),"false");
    }

    @Test
    public void equalTest5() {
        assertEquals(PLp1.interpret("equalp->([1],[])"),"false");
    }

    @Test
    public void equalTest6() {
        assertEquals(PLp1.interpret("equalp->([],[1])"),"false");
    }

    @Test
    public void firstTest1() {
        assertEquals(PLp1.interpret("first->([1,2,3])"),"1");
    }

    @Test
    public void firstTest2() {
        assertEquals(PLp1.interpret("first->([])"),"Runtime Error");
    }

    @Test
    public void insertTest1() {
        assertEquals(PLp1.interpret("insert->(1,[2,3]))").replaceAll("\\s",""),"[1,2,3]");
    }

    @Test
    public void insertTest2() {
        assertEquals(PLp1.interpret("insert->(1,[])").replaceAll("\\s",""),"[1]");
    }

    @Test
    public void lengthTest1() {
        assertEquals(PLp1.interpret("length->([1,2,3])"),"3");
    }

    @Test
    public void lengthTest2() {
        assertEquals(PLp1.interpret("length->([])"),"0");
    }

    @Test
    public void lengthTest3() {
        assertEquals(PLp1.interpret("length->(rest->([1]))"),"0");
    }

    @Test
    public void listfTest1() {
        assertEquals(PLp1.interpret("list->(1,2,3)").replaceAll("\\s",""),"[1,2,3]");
    }

    @Test
    public void listfTest2() {
        assertEquals(PLp1.interpret("list->(3)").replaceAll("\\s",""),"[3]");
    }

    @Test
    public void listpTest1() {
        assertEquals(PLp1.interpret("listp->([1,2,3])"),"true");
    }

    @Test
    public void listpTest2() {
        assertEquals(PLp1.interpret("listp->([])"),"true");
    }

    @Test
    public void listpTest3() {
        assertEquals(PLp1.interpret("listp->(3)"),"false");
    }

    @Test
    public void numberpTest1() {
        assertEquals(PLp1.interpret("numberp->(3)"),"true");
    }

    @Test
    public void numberpTest2() {
        assertEquals(PLp1.interpret("numberp->([1])"),"false");
    }

    @Test
    public void pairTest1() {
        assertEquals(PLp1.interpret("pairp->([1,2,3])"),"true");
    }

    @Test
    public void pairpTest2() {
        assertEquals(PLp1.interpret("pairp->([])"),"false");
    }

    @Test
    public void restTest1() {
        assertEquals(PLp1.interpret("rest->([])"),"Runtime Error");
    }

    @Test
    public void restTest2() {
        assertEquals(PLp1.interpret("rest->(rest->([1]))"),"Runtime Error");
    }

    @Test
    public void restTest3() {
        assertEquals(PLp1.interpret("rest->(rest->([1,2,3]))").replaceAll("\\s",""),"[3]");
    }

    @Test
    public void switchTest1() {
        assertEquals(PLp1.interpret("switch { case false: 1 case true:  2 default: 3}"),"2");
    }

    @Test
    public void switchTest2() {
        assertEquals(PLp1.interpret("switch { case true: 1 case true:  2 default: 3}"),"1");
    }

    @Test
    public void switchTest3() {
        assertEquals(PLp1.interpret("switch { case false: 1 case false:  2 default: 3}"),"3");
    }

}
