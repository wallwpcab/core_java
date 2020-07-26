class  Test{
 public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
    Scanner scanner = new Scanner(System.in);
      int age = scanner.nextInt();
      if(age > 60){
        throw new TooOldException("Your age is more than expected");
    }
    else if(age < 18){
        throw new TooOldException("Your age is more than expected");
    }
	else{
        System.out.println("");
      }
    }
}