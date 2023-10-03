import java.util.*;

public class Main {
    public static void main(String[] args) {
            // HashMap
        HashMap<Student,Integer> hashMap = new HashMap<>();
//        LinkedHashMap<Student,Integer> hashMap = new LinkedHashMap<>(); // có thứ tứ
        Student s1 = new Student("Hùng");
        hashMap.put(s1,20); // thêm mới và chỉnh sửa
        hashMap.put(new Student("Nam"),5); // thêm mới và chỉnh sửa
        hashMap.put(new Student("Anh"),50); // thêm mới và chỉnh sửa


        System.out.println(hashMap);
        hashMap.put(s1,100);
        System.out.println(hashMap);
//        duyệt map
//        duyệt theo key
                for (Student s : hashMap.keySet()){
                    System.out.println("key "+s);
                    System.out.println("Value "+hashMap.get(s));
                }
//        duyệt theo value
                for (Integer value: hashMap.values()){
                    System.out.println(value);
                }
                // duyệt theo entry
            for (Map.Entry<Student,Integer> entry: hashMap.entrySet()){
                System.out.println("key "+entry.getKey());
                System.out.println("Value "+entry.getValue());
            }


        TreeMap<Student,Integer> treeMap = new
                TreeMap<>(Comparator.comparing(Student::getName).reversed());
        Student s2 = new Student("Hùng");
        treeMap.put(s2,null); // thêm mới và chỉnh sửa
        treeMap.put(new Student("Nam"),null); // thêm mới và chỉnh sửa
        Student s3= new Student("Anh");
        treeMap.put(s3,50); // thêm mới và chỉnh sửa
        treeMap.put(new Student("Phát"),null); // thêm mới và chỉnh sửa
        // Phát -> Nam -> Hùng -> Anh
//        System.out.println(treeMap.get(s2));
        // lấy Entry
        System.out.println(treeMap.lowerEntry(s3));
        TreeMap<String,Integer> studentIntegerTreeMap = new TreeMap<>();
        studentIntegerTreeMap.put("Hùng",1);
        studentIntegerTreeMap.put("Nam",1);
        studentIntegerTreeMap.put("Anh",1);
        studentIntegerTreeMap.put("Đức",1);
        studentIntegerTreeMap.put("Bóng",1);
        System.out.println(studentIntegerTreeMap);
    }
}