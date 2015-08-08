package com.sankoudai.java.basics.oop;

import junit.framework.TestCase;

/**
 *
 * 测试obj.attr, 与obj.method()的调用过程：
 *      情景： obj是parent2类型的引用， 指向的实际是Child类型的对象
 *
 *      Resolve obj.attr比较简单， 仅仅根据名片类型（reference type)， 来决定attr实际的位置。
 *          如果名片类型没有定义（或继承）attr, 则obj.attr不允许。
 *          如果名片类型定义了attr, obj的实际类型是是子类型， 但自己重新定义了attr，给予了不同的值
 *              实际返回的仍是名片类型的值。
 *          也就是：继承中， 变量只会被hidden, 不会被覆盖。 根据名片找员工， 会找到名片中对应的值， 不是实际对象中的值
 *
 *      Resolve obj.method():
 *          首先， 如同attr一样， 如果method()在Parent2中没有定义(或者私有），则这个写法是不合法的。
 *          如果Parent2定义了method在子类中已被重定义， 显然会调用子类的定义， 因为子类方法会override父类方法。
 *              如果子类方法中使用到的成员变量， 先寻找自己中定义和给值的， 然后猜去看继承而来的。
 *              如果子类方法中使用到其他方法， 当然也先寻找自己中定义的， 然后才去寻找继承而来的。
 *              如果结果调用父类中的方法parent2Method，则parent2Method中用到成员变量，一律都使用Parent2中的定义（或继承）的成员变量值。
 *          如果Parent2中的method未被覆盖， 则会调用该方法， 该方法是被继承了的。
 *               如果父类方法调用了一个成员方法， 由于方法的覆盖原则， 需要先寻找子类中的方法， 然后才看自身方法；
 *               如果使用的是子类方法， 则子类方法中使用的成员变量， 先寻找自己中定义和给值的， 然后才看父类中的值。
 *          简单来说： obj.memeber.. member的可用范围由名片决定。 继承中， 成员变量是隐藏的，  成员方法是覆盖的。
 *
 *      关于不可见成员变量和方法：
 *          private的attr， 在obj.attr及Obj.method()的分辨中不会引起任何麻烦， 因为private量都能被本类中的其他成员看见。
 *          唯一引起麻烦的地方在， 如果obj.method()调用了父类中的方法methodParent2()，
 *          methodParent2()调用一个方法method2(),该方法是父类的private方法，
 *          则此时不管Child类中是否有相同签名的方法， methodParent2()都会调用该死用方法。
 *          这是因为， methodParent2()的定义中绑定的method2()方法， 本质是Parent2中的方法，
 *          由于其是私有的， 并没有被子类中的同名方法覆盖。  （而如果method2()在父类中是Public的，
 *          在子类中是private, 此时, 此时会出现编译错误！ 因为： 子类会继承一个Public方法， 你不能再
 *          定义一个相同签名，更窄可视范围的方法了。）
 *
 * @author : sankoudai
 * @version : created at 2015/8/8
 */
public class TestMemberResolvation extends TestCase {
    public void testStaticField() {
        /* Direct access from class:
           static field can be inherited; static field can be overriden;
           parent static field and child static field are stored seperately
        */
        System.out.printf("Parent staticMarker=%s \n", MemberResolvationParent.staticMarker);
        System.out.printf("Child staticMarker=%s \n", MemberResolvationChild.staticMarker);
        System.out.printf("Child2 staticMarker=%s \n", MemberResolvationChild2.staticMarker);
        System.out.println();

        /*Direct access from object: same as class access*/
        System.out.printf("Parent staticMarker=%s (from object) \n", new MemberResolvationParent().staticMarker);
        System.out.printf("Child staticMarker=%s (from object) \n", new MemberResolvationChild().staticMarker);
        System.out.printf("Child2 staticMarker=%s (from object) \n", new MemberResolvationChild2().staticMarker);
        System.out.println();

        /*Access from object (after up conversion):  access parent staticMarker */
        MemberResolvationParent parent = new MemberResolvationParent();
        MemberResolvationParent child = new MemberResolvationChild();
        MemberResolvationParent child2 = new MemberResolvationChild2();
        System.out.printf("Parent staticMarker=%s (from up-conversioned object) \n", parent.staticMarker);
        System.out.printf("Child staticMarker=%s (from up-conversioned  object) \n", child.staticMarker);
        System.out.printf("Child2 staticMarker=%s (from up-conversioned object) \n", child2.staticMarker);
    }

    public void testStaticMethod() {
        /* Direct access from class:
           static method can be inherited; static method can be overriden;
           parent static method and child static method are stored seperately
        */
        System.out.printf("Parent staticMethodMarker=%s \n", MemberResolvationParent.getStaticMethodMarker());
        System.out.printf("Child staticMethodMarker=%s \n", MemberResolvationChild.getStaticMethodMarker());
        System.out.printf("Child2 staticMethodMarker=%s \n", MemberResolvationChild2.getStaticMethodMarker());
        System.out.println();

        /*Direct access from object: same as class access*/
        System.out.printf("Parent staticMethodMarker=%s (from object) \n", new MemberResolvationParent().getStaticMethodMarker());
        System.out.printf("Child staticMethodMarker=%s (from object) \n", new MemberResolvationChild().getStaticMethodMarker());
        System.out.printf("Child2 staticMethodMarker=%s (from object) \n", new MemberResolvationChild2().getStaticMethodMarker());
        System.out.println();

        /*Access from object (after up conversion):  access  parent staticMethod*/
        MemberResolvationParent parent = new MemberResolvationParent();
        MemberResolvationParent child = new MemberResolvationChild();
        MemberResolvationParent child2 = new MemberResolvationChild2();
        System.out.printf("Parent staticMethodMarker=%s (from up-conversioned object) \n", parent.getStaticMethodMarker());
        System.out.printf("Child staticMethodMarker=%s (from up-conversioned  object) \n", child.getStaticMethodMarker());
        System.out.printf("Child2 staticMethodMarker=%s (from up-conversioned object) \n", child2.getStaticMethodMarker());
    }


    public void testAttribute() {
        /* Access from object:
            If child defines an attribute with same name,
            inherited parent attribute will be hidden when accessed directly.
            But the inherited attribute is still there.
        */
        MemberResolvationChild child = new MemberResolvationChild();
        System.out.printf("Child: parent-attributeMarker =%s \n", child.getParentAttributeMarker());
        System.out.printf("Child: attributeMarker =%s \n", child.attributeMarker);
        System.out.println();

        /* Access from object (after up conversion):
            The accessed attribute depends on referencing type, though pointing to same object.
            Inherited parent-defined attribute will be accessed, when referencing type is parent.
            Child-defined Attribute will be accessed , when referencing type is child.
         */
        MemberResolvationParent parent = child;
        System.out.printf("parent(up-conversioned from child): attributeMarker =%s \n", parent.attributeMarker);
        System.out.printf("Child: attributeMarker =%s \n", child.attributeMarker);
        System.out.println();
    }


    public void testMethod() {
        /* Access from object:
            Child-defined method overrides parent-defined method.
            When accessed, overridden parent-defined method is hidden.
         */
        MemberResolvationChild child = new MemberResolvationChild();
        System.out.printf("Child: methodMarker =%s \n", child.getMethodMarker());
        System.out.println();

       /* Access from object (after up conversion):
            The accessed method depends on actual type, regardless of referencing type.
            The child-defined method is always called, whether referencing type is parent of child.
            This is quite the opposite of attribute access.
         */
        MemberResolvationParent parent = child;
        System.out.printf("parent(up-conversioned from child): methodMarker =%s \n", parent.getMethodMarker());
        System.out.printf("Child: methodMarker =%s \n", child.getMethodMarker());
        System.out.println();
    }

    public void testAttributeAccessFromMethod() {
        MemberResolvationChild child = new MemberResolvationChild();
        /* Method attribute access:
            Child-defined method access child-defined attribute prior to inherited one.
            Parent-defined method access parent-defined attribute prior to the child-defined
         */
        System.out.printf("child: child-defined method access attribute=%s \n", child.childDefinedAttributeAccessMethod());
        System.out.printf("child: parent-defined method access attribute=%s \n", child.parentDefinedAttributeAccessMethod());
    }

    public void testMethodCallFromMethod() {
        MemberResolvationChild child = new MemberResolvationChild();

        /* child calls method which accesses public method:
            Child-defined method calls another child-defined public method prior to the parent-defined.
            Parent-defined method calls child-defined public method prior to the parent-defined.
         */
        System.out.printf("child: child-defined method calls public method, methodMarker=%s \n",
                child.childDefinedMethodCallPublicMethod());
        System.out.printf("child: parent-defined method calls public method, methodMarker=%s \n",
                child.parentDefinedMethodCallPublicMethod());
        System.out.println();

        /* (up-conversioned) parent calls method which accesses public method:
            Parent-defined method calls child-defined public method prior to the parent-defined.
        */
        MemberResolvationParent parent = child;
        System.out.printf("parent(up-conversioned from child): parent-defined method calls public method, methodMarker=%s \n",
                parent.parentDefinedMethodCallPublicMethod());
        System.out.println();

        /* child calls method which accesses public method:
            Parent-defined method calls child-defined public method prior to the parent-defined.
         */
        System.out.printf("child: child-defined method calls private method, methodMarker=%s \n",
                child.childDefinedMethodCallPrivateMethod());
        System.out.printf("child: parent-defined method calls private method, methodMarker=%s \n",
                child.parentDefinedMethodCallPrivateMethod());
        System.out.println();
    }
}

class MemberResolvationParent {
    static String staticMarker = "parent static marker";
    String attributeMarker = "parent attribute marker";

    static String getStaticMethodMarker() {
        return "parent static method marker";
    }

    String getMethodMarker() {
        return "parent method marker";
    }

    String parentDefinedAttributeAccessMethod() {
        return attributeMarker;
    }

    String parentDefinedMethodCallPublicMethod() {
        return getMethodMarker();
    }

    String parentDefinedMethodCallPrivateMethod() {
        return getPrivateMethodMarker();
    }

    private String getPrivateMethodMarker() {
        return "parent privateMethodMarker";
    }
}

class MemberResolvationChild extends MemberResolvationParent {
    static String staticMarker = "child static marker";
    public String attributeMarker = "child attribute marker";

    static String getStaticMethodMarker() {
        return "child static method marker";
    }


    String getMethodMarker() {
        return "child method marker";
    }

    String childDefinedAttributeAccessMethod() {
        return attributeMarker;
    }

    String getParentAttributeMarker() {
        return super.attributeMarker;
    }

    String childDefinedMethodCallPublicMethod() {
        return getMethodMarker();
    }

    String childDefinedMethodCallPrivateMethod() {
        return getPrivateMethodMarker();
    }

    private String getPrivateMethodMarker() {
        return "child privateMethodMarker";
    }
}

class MemberResolvationChild2 extends MemberResolvationParent {

}