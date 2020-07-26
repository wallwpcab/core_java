import Java.util.Scanner;
class TooYoungException extends RuntimeException{
  TooYoungException(String s){
     super(s);
  }
}
class TooOldException extends RuntimeException{
 TooOldException(String s){
   super(s);
  }
}