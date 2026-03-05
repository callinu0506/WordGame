// Jessie Baker, JES2371614
// CIS263AA, LESSON 3
// DATE: 03/03/26

// Create Players class to extend Person and hold money.
public class Players extends Person
{
   private int money = 1000;
   
   Players()
   {
      super();
      money = 1000;
   }
   
   Players(String firstName)
   {
      super(firstName);
      money = 1000;
   }
   
   Players(String firstName, String lastName)
   {
      super(firstName, lastName);
      money = 1000;
   }
   
   // Method to set money variable.
   public void setMoney(int currMoney)
   {
      money = currMoney;
   }
   
   // Method to get player's money variable.
   public int getMoney()
   {
      return money;
   }
   
   // Override toString method to return player full name
   // with their money.
   @Override
   public String toString()
   {
      return super.fullName() + ": $" + money + ".00";
   } 
}