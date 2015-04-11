package algorithms.problems.AlgorithmDesignAndAnalysis;

class StudyExample {

    public static void main(String[] args) {
        StudyExample studyExample=new StudyExample();
        char[] name = "there is nothing like anything".toCharArray();
        name=studyExample.getUnique(name);

        for(int i=0;i<name.length;i++){
            System.out.print(name[i]);

        }
        System.out.println(studyExample.getUnique(name).toString());
     }

    public char[] getUnique(char[] name) {

        Boolean[] uniq=new Boolean[128];
        int count=1;
        int checker=0;
        for(int i=1;i<name.length;i++) {
            int j;
            for( j=0;j<count;j++){
                if(name[i]==name[j]){
                    break;
                }
            }
                if(j==count) {
                    name[count] = name[i];
                    count++;
//                    System.out.println("Inside main()"+name[i]);
                }
        }
        name[count]=0;
        return name;
    }

}