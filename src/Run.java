public class Run{
    public static void main(String[] args) {
        Red red=new Red();
        Skirt redSkirt=new Skirt(red);
        redSkirt.operation();

        Yellow yellow=new Yellow();
        Skirt yellowSkirt=new Skirt(yellow);
        yellowSkirt.operation();
    }
}

class Skirt {
    public Color color;
    public Skirt(Color color){
        this.color=color;
    }
    public void operation() {
        this.color.show();
    }
}

interface Color{
    public void show();
}

class Red implements Color{
    public Red(){}
    public void show() {}
}

class Yellow implements Color{
    public Yellow(){}
    public void show() {}
}


class RedSkirt {
    public Red red=new Red();
    public RedSkirt(){}
    public void operation() {
        red.show();
    }
}

class YellowSkirt {
    public Yellow red=new Yellow();
    public YellowSkirt(){}
    public void operation() {
        red.show();
    }
}


// 接口是一种更加抽象的类型，作用可以使得代码具有更好的扩展性。
// 举个简单的例子：
// 最开始的需求时写一个裙子，于是有了裙子类：
// class Skirt {
//     public Skirt(){}
//     public void operation() {}
// }
// 有了裙子以后，客户说需要红色裙子，于是增加一个红色类：
// class Skirt {
//     public Red red=new Red();
//     public Skirt(){}
//     public void operation() {
//         red.show();
//     }
// }

// class Red{
//     public Red(){}
//     public void show() {}
// }
// 有了红色的裙子，客户又来提需求了，想要淡黄的长裙：
// class Skirt {
//     public Red red=new Red();
//     public Skirt(){}
//     public void operation() {
//         red.show();
//     }
// }

// class Red{
//     public Red(){}
//     public void show() {}
// }

// class Yellow{
//     public Yellow(){}
//     public void show() {}
// }
// 有了增加了淡黄的颜色类之后，发现原来的裙子类也要跟着修改才行：
// class RedSkirt {
//     public Red red=new Red();
//     public RedSkirt(){}
//     public void operation() {
//         red.show();
//     }
// }

// class YellowSkirt {
//     public Yellow red=new Yellow();
//     public YellowSkirt(){}
//     public void operation() {
//         red.show();
//     }
// }

// class Red{
//     public Red(){}
//     public void show() {}
// }

// class Yellow{
//     public Yellow(){}
//     public void show() {}
// }
// 这下红色裙子和淡黄的长裙都有了，但是客户的需求又来了，需要白色裙子、蓝色裙子、黑色裙子。。。。。。，这下子可怎么办？每增加一个颜色类，裙子类都要修改，这样的设计在系统庞大以后弊端就越来越明显，系统的扩展性很差，很难维护。
// 能不能有一种办法：不管增加什么样的颜色类，都不用修改原先的裙子类。裙子类需要一个颜色类，它只需要知道自己需要一个颜色属性，先给他一个抽象的颜色把坑占了，具体的颜色等后面随客户的随求随便修改。有没有一个抽象的类型，能代替各种颜色，那就是接口：
// class Skirt {
//     public Color color;
//     public Skirt(Color color){
//         this.color=color;
//     }
//     public void operation() {
//         this.color.show();
//     }
// }

// interface Color{
//     public void show();
// }
// 现在不管客户需要红色裙子，就增加红色类并把新增的红色类给裙子就行。如果需要淡黄的长裙，就增加黄色类，如果需要豹纹裙，就增加豹纹类。只要新增的类继承颜色接口并实现了方法就好。
// public class Run{
//     public static void main(String[] args) {
//         Red red=new Red();
//         Skirt redSkirt=new Skirt(red);
//         redSkirt.operation();

//         Yellow yellow=new Yellow();
//         Skirt yellowSkirt=new Skirt(yellow);
//         yellowSkirt.operation();
//     }
// }

// class Skirt {
//     public Color color;
//     public Skirt(Color color){
//         this.color=color;
//     }
//     public void operation() {
//         this.color.show();
//     }
// }

// interface Color{
//     public void show();
// }

// class Red implements Color{
//     public Red(){}
//     public void show() {}
// }

// class Yellow implements Color{
//     public Yellow(){}
//     public void show() {}
// }
// 现在的代码，就可以随意扩展颜色类，而不用修改原来裙子类，符合开闭原则。
// 感兴趣的小伙伴可以思考一下：如果不仅仅是扩展颜色类，并且要扩展裙子类呢？长裙or短裙。甚至是扩展衣服类呢？不仅仅是裙子，新增帽子or鞋子。
// 能力有限，如有错误，欢迎斧正!