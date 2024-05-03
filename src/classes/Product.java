package classes;

public class Product {

    String name;
    int price;
    int count;

    void sell(int count){
        if(count <= this.count && count >= 0){
            this.count -= count;
            System.out.println("Вы купили " + count + " " + name + ".");
            System.out.println("Осталось в наличии " + this.count + " " + name + ".");
        } else if (count > this.count){
            System.out.println("Такого количества " + name + " нет в наличии.");
        } else{
            System.out.println("Корректно введите количество товара.");
        }
    }

}
