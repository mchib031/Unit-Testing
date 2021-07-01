public class Twitter {

  public String loadTweet()
  {
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {}

    double r =  Math.random();
    if (r <= 0.45) {
      return "I am tweet that likes to talk about @me";
    } else if (r <= 0.9) {
      return "Hello to @you";
    } else {
      return null;
    }
  }

// modifier la methode isMentionned pour faire fonctionner les 4 tests
   public boolean isMentionned(String name) {
    String tweet = loadTweet();
    if (tweet==null){
      return false;
    }
    int tweet_1 = tweet.indexOf("@"); 
    // indexOf() renvoie la position de la première occurrence du ou des caractères spécifiés dans une chaîne.
    int tweet_2 = tweet.indexOf(" ",tweet_1);
    if (tweet_2 == -1){
      tweet = tweet.substring(tweet_1); 
      //renvoie une nouvelle chaîne qui est une sous-chaîne de cette chaîne.
    }else{tweet = tweet.substring(tweet_1,tweet_2);
    }return tweet.equals("@" + name); 
  }
}

