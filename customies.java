//import Java.util.Scanner;
class TooYoundException extends RuntimeException{
  TooYoungException(String s) {
      super(s); // Too make description available to default exception handler
   }
}
class TooOldException extends RuntimeException{
   TooOldException(String s){
       super(s); // Too make description available to default exception handler
    }
}