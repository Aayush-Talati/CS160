public class SampleGrader6 {
    public static void main(String[] args) {
        RecursiveMethods prog = new RecursiveMethods();
        
        int partI = prog.byLeapsAndBounds(3);
        System.out.println("Part I answer: " + partI); //should print Part I answer: 3

        int partII = prog.subCount("aaaa","a");
        System.out.println("Part II answer: " + partII); //should print Part II answer: 4

     }
}