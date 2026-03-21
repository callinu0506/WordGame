// Jessie Baker, JES2371614
// CIS263AA, LESSON 5
// DATE: 03/18/26

// Create Person class to hold first and last name.
public class Person
{
   private String fName;
   private String lName;
   
   Person()
   {
      fName = "";
      lName = "";
   }
   
   Person(String firstName)
   {
      fName = firstName;
      lName = "";
   }
   
   Person(String firstName, String lastName)
   {
      fName = firstName;
      lName = lastName;
   }
   
   // Two method options to set name with either first name only or first and last name.
   public void setName(String firstName)
   {
      fName = firstName;
      lName = "";
   }
   
   public void setName(String firstName, String lastName)
   {
      fName = firstName;
      lName = lastName;
   } 
   
   // Two methods to get person's first and last name
   public String getFirst()
   {
      return fName;
   }
   
   public String getLast()
   {
      return lName;
   }
   
   // Method to return full name
   public String fullName()
   {
      String fullName;
      
      if (lName.isEmpty()) 
      {
         fullName = getFirst();
      }
      else
      {
         fullName = getFirst() + " " + getLast();
      }
      return fullName;
   } 
   
}