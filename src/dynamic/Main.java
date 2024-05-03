package dynamic;

public class Main {

    public static void main(String[] args) {

       /* DynamicStringArray d1 = new DynamicStringArray();
        d1.add("1");
        d1.add("2");
        d1.add("3");
        d1.add("4");
        d1.add("5");
        d1.arrayDem();

        d1.add("6");
        d1.add("7");
        d1.arrayDem();

        d1.remove(2);
        d1.arrayDem();
        d1.remove(0);
        d1.arrayDem();

        d1.addToPos(1, "aaa");
        d1.arrayDem();
        d1.addToPos(5, "bbb");
        d1.arrayDem();
        d1.addToPos(7, "ccc");
        d1.arrayDem();
        d1.addToPos(0, "ddd");
        d1.arrayDem();
        d1.addToPos(5,"eee");
        d1.arrayDem();
        d1.addToPos(0, "fff");
        d1.arrayDem();

        System.out.println(d1.contains("aaa"));
        System.out.println(d1.contains("abc"));

        d1.add("aaa");
        d1.arrayDem();

        System.out.println(d1.indexOf("aaa"));
        System.out.println(d1.lastIndexOf("aaa"));
        System.out.println(d1.lastIndexOf("abc"));*/

      /*  DynamicStringArray array1 = new DynamicStringArray(); // 1 Task
        array1.add("a");
        array1.add("b");
        array1.add("a");
        array1.add("a");
        array1.add("c");
        array1.add("a");
        array1.add("a");
        array1.add("d");

        array1.arrayDem();

        for(int i = 0; i < array1.size(); i++){
            if(array1.get(i).equals("a")){
                array1.remove(i);
                i--;
            }
        }

        array1.arrayDem();*/
        DynamicStringArray array1 = new DynamicStringArray(); // 2 Task
        array1.add("a");
        array1.add("b");
        array1.add("a");
        array1.add("a");
        array1.add("c");
        array1.add("a");
        array1.add("a");
        array1.add("d");

        array1.arrayDem();

        DynamicStringArray array2 = new DynamicStringArray();
        array2.add("a");
        array2.add("b");

        /*for(int i = 0; i < array2.size(); i++){
            for(int j = 0; j < array1.size(); j++){
                if(array1.get(j).equals(array2.get(i))){
                    array1.remove(j);
                    j--;
                }
            }
        }*/

        for(int i = 0; i < array1.size(); i++){
            if(array2.contains(array1.get(i))){
                array1.remove(i);
                i--;
            }
        }


        array1.arrayDem();


    }
}
