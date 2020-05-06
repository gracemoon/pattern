package Basic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class AnnotationReflect {
	public static void main(String[] args) throws ClassNotFoundException {

		TestInterface test1 = new Test1();
		TestInterface test2 = new Test2();
		JunitTest junitTest = new ConcreteJunit();
		junitTest.add(test1);
		junitTest.add(test2);
		junitTest.run();
	}
}

interface JunitTest {
	public void add(TestInterface object);
	public void run();
}

class ConcreteJunit implements JunitTest {
	private ArrayList<TestInterface> arrayList = new ArrayList<TestInterface>();

	public void add(TestInterface object) {
		arrayList.add(object);
	}

	public void run() {
		Iterator<TestInterface> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			TestInterface object = iterator.next();
			Method[] methods = object.getClass().getMethods();
			for (Method method : methods) {
				try {
                    if(method.isAnnotationPresent(Test.class)){
                        method.invoke(object);
                    }
				} catch (Exception e) {
                    e.printStackTrace();
				} 
			}
		}
	}
}

interface TestInterface{
    public void show();
}


class Test1 implements TestInterface{
    @Test
	public void show() {
		System.out.println("show");
	}
}


class Test2 implements TestInterface{
    @Test
	public void show() {
		System.out.println("display");
	}
}

// @Target(ElementType.TYPE)//只能应用于类上
// @Retention(RetentionPolicy.RUNTIME)//保存到运行时
//  @interface DBTable {
//     String name() default "";
// }


// @Target(ElementType.FIELD)
// @Retention(RetentionPolicy.RUNTIME)
//  @interface SQLInteger {
//     //该字段对应数据库表列名
//     String name() default "";
//     //嵌套注解
//     Constraints constraint() default @Constraints;
// }

// @Target(ElementType.FIELD)
// @Retention(RetentionPolicy.RUNTIME)
//  @interface SQLString {

//     //对应数据库表的列名
//     String name() default "";

//     //列类型分配的长度，如varchar(30)的30
//     int value() default 0;

//     Constraints constraint() default @Constraints;
// }


// @Target(ElementType.FIELD)//只能应用在字段上
// @Retention(RetentionPolicy.RUNTIME)
//  @interface Constraints {
//     //判断是否作为主键约束
//     boolean primaryKey() default false;
//     //判断是否允许为null
//     boolean allowNull() default false;
//     //判断是否唯一
//     boolean unique() default false;
// }


// @DBTable(name = "MEMBER")
// class Member {
//     //主键ID
//     @SQLString(name = "ID",value = 50, constraint = @Constraints(primaryKey = true))
//     private String id;

//     @SQLString(name = "NAME" , value = 30)
//     private String name;

//     @SQLInteger(name = "AGE")
//     private int age;

//     @SQLString(name = "DESCRIPTION" ,value = 150 , constraint = @Constraints(allowNull = true))
//     private String description;//个人描述

//    //省略set get.....
// }


// public class AnnotationReflect {

//   public static String createTableSql(String className) throws ClassNotFoundException {
//     Class<?> cl = Class.forName(className);
//     DBTable dbTable = cl.getAnnotation(DBTable.class);
//     //如果没有表注解，直接返回
//     if(dbTable == null) {
//       System.out.println(
//               "No DBTable annotations in class " + className);
//       return null;
//     }
//     String tableName = dbTable.name();
//     // If the name is empty, use the Class name:
//     if(tableName.length() < 1)
//       tableName = cl.getName().toUpperCase();
//     List<String> columnDefs = new ArrayList<String>();
//     //通过Class类API获取到所有成员字段
//     for(Field field : cl.getDeclaredFields()) {
//       String columnName = null;
//       //获取字段上的注解
//       Annotation[] anns = field.getDeclaredAnnotations();
//       if(anns.length < 1)
//         continue; // Not a db table column

//       //判断注解类型
//       if(anns[0] instanceof SQLInteger) {
//         SQLInteger sInt = (SQLInteger) anns[0];
//         //获取字段对应列名称，如果没有就是使用字段名称替代
//         if(sInt.name().length() < 1)
//           columnName = field.getName().toUpperCase();
//         else
//           columnName = sInt.name();
//         //构建语句
//         columnDefs.add(columnName + " INT" +
//                 getConstraints(sInt.constraint()));
//       }
//       //判断String类型
//       if(anns[0] instanceof SQLString) {
//         SQLString sString = (SQLString) anns[0];
//         // Use field name if name not specified.
//         if(sString.name().length() < 1)
//           columnName = field.getName().toUpperCase();
//         else
//           columnName = sString.name();
//         columnDefs.add(columnName + " VARCHAR(" +
//                 sString.value() + ")" +
//                 getConstraints(sString.constraint()));
//       }


//     }
//     //数据库表构建语句
//     StringBuilder createCommand = new StringBuilder(
//             "CREATE TABLE " + tableName + "(");
//     for(String columnDef : columnDefs)
//       createCommand.append("\n    " + columnDef + ",");

//     // Remove trailing comma
//     String tableCreate = createCommand.substring(
//             0, createCommand.length() - 1) + ");";
//     return tableCreate;
//   }


//     /**
//      * 判断该字段是否有其他约束
//      * @param con
//      * @return
//      */
//   private static String getConstraints(Constraints con) {
//     String constraints = "";
//     if(!con.allowNull())
//       constraints += " NOT NULL";
//     if(con.primaryKey())
//       constraints += " PRIMARY KEY";
//     if(con.unique())
//       constraints += " UNIQUE";
//     return constraints;
//   }

//   public static void main(String[] args) throws Exception {
//     String[] arg={"Basic.Member"};
//     for(String className : arg) {
//       System.out.println("Table Creation SQL for " +
//               className + " is :\n" + createTableSql(className));
//     }

//     /**
//      * 输出结果：
//      Table Creation SQL for com.zejian.annotationdemo.Member is :
//      CREATE TABLE MEMBER(
//      ID VARCHAR(50) NOT NULL PRIMARY KEY,
//      NAME VARCHAR(30) NOT NULL,
//      AGE INT NOT NULL,
//      DESCRIPTION VARCHAR(150)
//      );
//      */
//   }
// }